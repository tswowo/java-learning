package org.javaweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 员工操作日志实体类（完整字段版）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogOperator {
    /** 日志主键 */
    private Long id;

    /** 操作人ID */
    private Long operateEmpId = 1L; // 临时默认值，实际需从登录上下文获取

    /** 操作时间 */
    private LocalDateTime operateTime;

    /** 操作类名 */
    private String className = "org.javaweb.controller.EmpController"; // 固定为员工控制器

    /** 操作方法名（新增/删除/修改） */
    private String methodName;

    /** 方法参数（员工信息/删除ID等） */
    private String methodParams;

    /** 方法返回值（操作结果） */
    private String returnValue = "Result(code=1, msg=操作成功, data=null)";

    /** 方法耗时（毫秒） */
    private Long costTime;

    /** 操作人名称（当前登录员工姓名） */
    private String operateEmpName = "系统管理员"; // 临时默认值，实际需从登录态获取
}