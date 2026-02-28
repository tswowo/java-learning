package org.javaweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.javaweb.mapper.EmpExprMapper;
import org.javaweb.mapper.EmpMapper;
import org.javaweb.pojo.*;
import org.javaweb.service.EmpService;
import org.javaweb.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;
    private final EmpExprMapper empExprMapper;

    @Autowired
    public EmpServiceImpl(EmpMapper empMapper, EmpExprMapper empExprMapper) {
        this.empMapper = empMapper;
        this.empExprMapper = empExprMapper;
    }

    @Override
    public Result selectEmpByCondition(EmpQueryParam param) {
        log.info("【员工管理】接收到员工条件查询请求，查询参数：{}", param);
        if (param == null) {
            param = new EmpQueryParam();
            log.info("【员工管理】查询参数为空，初始化默认查询参数对象");
        }

        try {
            String name = param.getName();
            if (name != null) {
                name = name.trim();
                param.setName(name.isEmpty() ? null : name);
                log.info("【员工管理】姓名参数预处理完成，处理后：{}", param.getName());
            }

            Integer gender = param.getGender();
            if (gender != null && !(gender == 1 || gender == 2)) {
                log.warn("【员工管理】性别参数非法：{}，已置为null", gender);
                param.setGender(null);
            }

            Integer page = param.getPage();
            param.setPage(page == null ? 1 : page);
            Integer pageSize = param.getPageSize();
            param.setPageSize(pageSize == null ? 5 : pageSize);
            log.info("【员工管理】分页参数处理完成，当前页码：{}，每页条数：{}", param.getPage(), param.getPageSize());

            PageHelper.startPage(param.getPage(), param.getPageSize());
            List<Emp> empList = empMapper.selectEmpByCondition(param);
            log.info("【员工管理】员工条件查询执行完成，查询到{}条数据", empList.size());

            PageInfo<Emp> pageInfo = new PageInfo<>(empList);
            PageResult<Emp> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
            return Result.success(pageResult);
        } catch (Exception e) {
            log.error("【员工管理】员工条件查询执行异常，参数：{}", param, e);
            throw new BusinessException("员工条件查询失败，请稍后重试");
        }
    }

    @Override
    public Result deleteEmp(Integer[] ids) {
        // 开始计时
        log.info("【员工管理】接收到员工删除请求，待删除员工ID：{}", Arrays.toString(ids));
        if (ids == null || ids.length == 0) {
            log.warn("【员工管理】员工删除失败：未传入任何员工ID");
            throw new BusinessException("请选择要删除的记录");
        }

        try {
            for (Integer id : ids) {
                if (id == null) {
                    log.warn("【员工管理】跳过无效的空员工ID");
                    continue;
                }
                empExprMapper.deleteByEmpId(id);
                empMapper.deleteById(id);
                log.info("【员工管理】员工ID：{} 删除完成（含工作经历）", id);
            }
            log.info("【员工管理】批量删除员工完成，总计删除{}条记录", ids.length);


            return Result.success("员工删除成功");
        } catch (Exception e) {
            log.error("【员工管理】批量删除员工异常，待删除ID：{}", Arrays.toString(ids), e);
            throw new BusinessException("删除员工信息失败，请稍后重试");
        }
    }

    @Override
    public Result addEmp(Emp emp) {
        // 开始计时
        log.info("【员工管理】接收到员工新增请求，员工信息：{}", emp);
        if (emp == null) {
            log.warn("【员工管理】员工新增失败：传入员工对象为空");
            throw new BusinessException("请选择要添加的记录");
        }

        if (empMapper.selectByUsername(emp.getUsername()) != null) {
            log.warn("【员工管理】员工新增失败：该员工已存在");
            throw new BusinessException("【员工管理】员工新增失败：该员工" + emp.getUsername() + "已存在");
        }
        try {
            empMapper.addEmp(emp);
            Integer empId = emp.getId();
            log.info("【员工管理】员工主表新增完成，生成员工ID：{}", empId);

            List<EmpExpr> exprList = emp.getExprList();
            if (!ObjectUtils.isEmpty(exprList)) {
                exprList.forEach(expr -> expr.setEmpId(empId));
                empExprMapper.addEmpExpr(exprList);
                log.info("【员工管理】员工ID：{} 新增工作经历{}条", empId, exprList.size());
            }

            log.info("【员工管理】员工【{}】新增全流程完成", emp.getName());


            return Result.success("员工新增成功");
        } catch (Exception e) {
            log.error("【员工管理】员工新增异常，员工信息：{}", emp, e);
            throw new BusinessException("保存员工信息失败，请稍后重试");
        }
    }

    @Override
    public Result selectById(Integer id) {
        log.info("【员工管理】接收到员工详情查询请求，查询员工ID：{}", id);
        if (id == null) {
            log.warn("【员工管理】员工详情查询失败：未传入员工ID");
            throw new BusinessException("请选择要查询的记录");
        }

        try {
            Emp emp = empMapper.selectById(id);
            if (emp == null) {
                log.warn("【员工管理】员工详情查询：ID为{}的员工不存在", id);
                throw new BusinessException("查询的员工不存在");
            }

            List<EmpExpr> exprList = empExprMapper.selectEmpExprById(id);
            emp.setExprList(exprList);
            log.info("【员工管理】员工ID：{} 详情查询完成，包含{}条工作经历", id, exprList.size());
            return Result.success(emp);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("【员工管理】员工详情查询异常，员工ID：{}", id, e);
            throw new BusinessException("查询员工详情失败，请稍后重试");
        }
    }

    @Override
    public Result updateEmp(Emp emp) {
        // 开始计时
        log.info("【员工管理】接收到员工更新请求，待更新员工信息：{}", emp);
        if (emp == null || ObjectUtils.isEmpty(emp.getId())) {
            log.warn("【员工管理】更新员工失败：参数为空或未传入员工ID");
            throw new BusinessException("请选择要修改的记录");
        }
        Integer empId = emp.getId();

        try {
            Emp oldEmp = empMapper.selectById(empId);
            if (oldEmp == null) {
                log.warn("【员工管理】更新员工失败：ID={} 的员工不存在", empId);
                throw new BusinessException("员工不存在，无法更新");
            }

            fillEmptyFields(emp, oldEmp);
            log.info("【员工管理】员工ID：{} 空字段回填完成", empId);

            empMapper.updateEmp(emp);
            log.info("【员工管理】员工主表更新完成，ID:{}", empId);

            empExprMapper.deleteByEmpId(empId);
            log.info("【员工管理】清空员工ID:{} 历史工作经历完成", empId);

            List<EmpExpr> exprList = emp.getExprList();
            if (!ObjectUtils.isEmpty(exprList)) {
                exprList.forEach(expr -> expr.setEmpId(empId));
                empExprMapper.addEmpExpr(exprList);
                log.info("【员工管理】员工ID:{} 插入新工作经历 {} 条", empId, exprList.size());
            }

            log.info("【员工管理】员工ID：{} 信息+工作经历全量更新完成", empId);


            return Result.success("员工信息更新成功");
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("【员工管理】员工更新执行异常，员工ID：{}", empId, e);
            throw new BusinessException("系统异常，更新失败");
        }
    }

    @Override
    public Result selectAllEmp() {
        log.info("【员工管理】接收到全量员工列表查询请求");
        try {
            EmpQueryParam param = new EmpQueryParam();
            List<Emp> empList = empMapper.selectEmpByCondition(param);
            log.info("【员工管理】全量员工查询完成，共{}条数据", empList.size());
            return Result.success(empList);
        } catch (Exception e) {
            log.error("【员工管理】全量员工查询异常", e);
            throw new BusinessException("查询员工列表失败，请稍后重试");
        }
    }

    @Override
    public Result login(Emp emp) {
        Emp e = empMapper.selectByUsernameAndPassword(emp);
        if (e == null)
            throw new BusinessException("用户名或密码错误");
        log.info("【员工管理】员工登录成功，用户名：{}", emp.getUsername());
        log.info("【员工管理】当前用户详细信息：{}", emp);
        Map<String,Object> clamis = new HashMap<>();
        clamis.put("id",e.getId());
        clamis.put("username",e.getUsername());
        String token=JWTUtils.generateJwt(clamis );

        return Result.success(new LoginInfo(e.getId(), e.getUsername(), e.getPassword(), token));
    }

    // 空字段填充工具方法
    private void fillEmptyFields(Emp emp, Emp oldEmp) {
        emp.setUsername(ObjectUtils.isEmpty(emp.getUsername()) ? oldEmp.getUsername() : emp.getUsername());
        emp.setPassword(ObjectUtils.isEmpty(emp.getPassword()) ? oldEmp.getPassword() : emp.getPassword());
        emp.setName(ObjectUtils.isEmpty(emp.getName()) ? oldEmp.getName() : emp.getName());
        emp.setGender(ObjectUtils.isEmpty(emp.getGender()) ? oldEmp.getGender() : emp.getGender());
        emp.setImage(ObjectUtils.isEmpty(emp.getImage()) ? oldEmp.getImage() : emp.getImage());
        emp.setJob(ObjectUtils.isEmpty(emp.getJob()) ? oldEmp.getJob() : emp.getJob());
        emp.setSalary(ObjectUtils.isEmpty(emp.getSalary()) ? oldEmp.getSalary() : emp.getSalary());
        emp.setEntryDate(ObjectUtils.isEmpty(emp.getEntryDate()) ? oldEmp.getEntryDate() : emp.getEntryDate());
        emp.setDeptId(ObjectUtils.isEmpty(emp.getDeptId()) ? oldEmp.getDeptId() : emp.getDeptId());

        emp.setDeptName(oldEmp.getDeptName());
        emp.setCreateTime(oldEmp.getCreateTime());
        emp.setUpdateTime(oldEmp.getUpdateTime());
    }

}
