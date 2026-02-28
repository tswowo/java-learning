package org.javaweb.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.javaweb.mapper.OperateLogMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.javaweb.pojo.*;
import org.javaweb.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 操作日志切面类
 */
@Aspect // 标记为切面类
@Component // 交给Spring容器管理
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 初始化JSON转换器，用于序列化参数和返回值
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()); // 支持Java 8时间类型序列化


    /**
     * 环绕通知：在目标方法执行前后获取日志信息
     */
    @Around("@annotation(org.javaweb.anno.LogOperation)")
    public Object recordOperateLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 初始化日志对象
        OperateLog operateLog = new OperateLog();

        // 2. 记录操作时间
        operateLog.setOperateTime(LocalDateTime.now());

        // 3. 获取目标类和方法信息
        String className = joinPoint.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();

        operateLog.setClassName(className);
        operateLog.setMethodName(methodName);

        // 4. 获取方法参数并序列化
        Object[] args = joinPoint.getArgs();
        try {
            String paramsJson = objectMapper.writeValueAsString(args);
            operateLog.setMethodParams(paramsJson);
        } catch (JsonProcessingException e) {
            operateLog.setMethodParams("参数序列化失败：" + e.getMessage());
        }

        // 5. 获取操作人ID（此处需根据你的实际登录上下文获取，示例中暂设为1，需替换为真实逻辑）
        // 例如：从ThreadLocal、Token、Session中获取当前登录用户ID
        Integer operateEmpId = getCurrentEmpId();
        operateLog.setOperateEmpId(operateEmpId);

        Object result = null;
        long startTime = System.currentTimeMillis();
        try {
            // 6. 执行目标方法
            result = joinPoint.proceed();
            return result;
        } finally {
            // 7. 计算方法执行时长（无论方法是否异常，都记录日志）
            long costTime = System.currentTimeMillis() - startTime;
            operateLog.setCostTime(costTime);

            // 8. 处理返回值并序列化
            try {
                String returnValueJson = objectMapper.writeValueAsString(result);
                // 防止返回值过长超出数据库字段长度
                if (returnValueJson.length() > 2000) {
                    operateLog.setReturnValue(returnValueJson.substring(0, 1997) + "...");
                } else {
                    operateLog.setReturnValue(returnValueJson);
                }
            } catch (JsonProcessingException e) {
                operateLog.setReturnValue("返回值序列化失败：" + e.getMessage());
            }

            // 9. 保存日志到数据库（建议异步执行，避免影响接口响应速度）
            saveOperateLog(operateLog);
        }
    }

    /**
     * 获取当前操作人ID（需根据你的项目实际情况实现）
     */
    private Integer getCurrentEmpId() {

        return CurrentHolder.getCurrentEmpId();
    }

    /**
     * 保存操作日志（建议改为异步执行）
     */
    private void saveOperateLog(OperateLog operateLog) {
        try {
            operateLogMapper.insertOperationLog(operateLog);
        } catch (Exception e) {
            // 日志保存失败不影响主业务，此处可记录日志告警
            System.err.println("保存操作日志失败：" + e.getMessage());
        }
    }

    /**
     * 员工登录操作日志切面
     */
    @Around("@annotation(org.javaweb.anno.LogLogin)")
    public Object LoginOperateLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 初始化日志对象
        EmpLoginLog operateLog = new EmpLoginLog();

        // 2. 记录操作时间
        operateLog.setLoginTime(LocalDateTime.now());

        // 3. 提取登录参数中的用户名和密码
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                if (arg instanceof Emp emp) {
                    operateLog.setUsername(emp.getUsername());
                    operateLog.setPassword(emp.getPassword());
                    break;
                }
            }
        }

        long startTime = System.currentTimeMillis();
        try {
            // 4. 执行目标方法
            Object result = joinPoint.proceed();

            // 5. 登录成功，设置成功状态
            operateLog.setIsSuccess((short) 1);

            // 6. 安全提取JWT token
            if (result instanceof Result resultObj && resultObj.getData() instanceof LoginInfo loginInfo) {
                operateLog.setJwt(loginInfo.getToken());
            }

            return result;
        } catch (Exception e) {
            // 7. 登录失败，设置失败状态
            operateLog.setIsSuccess((short) 0);
            throw e;
        } finally {
            // 8. 计算方法执行时长并保存日志
            long costTime = System.currentTimeMillis() - startTime;
            operateLog.setCostTime(costTime);
            saveLoginLog(operateLog);
            // finally块不应该有return语句
        }
    }


    private void saveLoginLog(EmpLoginLog loginLog) {
        try {
            operateLogMapper.insertLoginLog(loginLog);
        } catch (Exception e) {
            // 日志保存失败不影响主业务，此处可记录日志告警
            System.err.println("保存操作日志失败：" + e.getMessage());
        }
    }
}