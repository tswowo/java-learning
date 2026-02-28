package org.javaweb.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.javaweb.mapper.DeptMapper;
import org.javaweb.pojo.BusinessException;
import org.javaweb.pojo.Dept;
import org.javaweb.pojo.Result;
import org.javaweb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Result selectAllDept() {
        log.info("【部门管理】开始查询所有部门信息");

        try {
            var result = deptMapper.selectAllDept();

            return Result.success(result);
        } catch (Exception e) {
            log.error("【部门管理】查询所有部门信息失败", e);
            throw new BusinessException("查询所有部门信息失败");
        }
    }

    @Override
    public Result selectByDept(Dept dept) {
        log.info("【部门管理】开始根据部门信息查询，参数：{}", dept);

        try {
            Dept dept1 = deptMapper.selectByDept(dept);
            if (dept1 == null) {
                log.warn("【部门管理】根据部门信息查询失败：该部门不存在，参数：{}", dept);
                throw new BusinessException("该部门不存在");
            }


            return Result.success(dept1);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("【部门管理】根据部门信息查询异常，参数：{}", dept, e);
            throw new BusinessException("查询部门信息失败");
        }
    }

    @Override
    public Result deleteById(Integer id) {
        log.info("【部门管理】开始删除部门，ID：{}", id);

        try {
            Dept dept = deptMapper.selectById(id);
            if (dept == null) {
                log.warn("【部门管理】删除部门失败：ID={} 不存在", id);
                throw new BusinessException("该Id不存在");
            }

            deptMapper.deleteById(id);
            String successMsg = "删除部门\"" + dept.getName() + "\"成功";
            log.info("【部门管理】{}", successMsg);


            return Result.success(successMsg);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("【部门管理】删除部门异常，ID：{}", id, e);
            throw new BusinessException("删除部门失败");
        }
    }

    @Override
    public Result selectById(Integer id) {
        log.info("【部门管理】开始根据ID查询部门，ID：{}", id);

        try {
            Dept dept = deptMapper.selectById(id);
            if (dept == null) {
                log.warn("【部门管理】根据ID查询部门失败：ID={} 不存在", id);
                throw new BusinessException("该Id不存在");
            }


            return Result.success(dept);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("【部门管理】根据ID查询部门异常，ID：{}", id, e);
            throw new BusinessException("查询部门信息失败");
        }
    }

    @Override
    public Result addDept(Dept dept) {
        log.info("【部门管理】开始添加部门，参数：{}", dept);

        try {
            if (deptMapper.selectByDept(dept) != null) {
                log.warn("【部门管理】添加部门失败：该部门已存在，参数：{}", dept);
                throw new BusinessException("添加失败，该部门已存在");
            }

            deptMapper.addDept(dept);
            String successMsg = "添加部门\"" + dept.getName() + "\"成功";
            log.info("【部门管理】{}", successMsg);

            return Result.success(successMsg);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("【部门管理】添加部门异常，参数：{}", dept, e);
            throw new BusinessException("添加部门失败");
        }
    }

    @Override
    public Result updateDept(Dept dept) {
        log.info("【部门管理】开始更新部门，参数：{}", dept);

        try {
            Dept dept1 = deptMapper.selectById(dept.getId());
            if (dept1 == null) {
                log.warn("【部门管理】更新部门失败：ID={} 不存在", dept.getId());
                throw new BusinessException("该Id不存在");
            }

            deptMapper.updateDept(dept);
            String successMsg = "更新部门\"" + dept.getName() + "\"成功";
            log.info("【部门管理】{}", successMsg);



            return Result.success(successMsg);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("【部门管理】更新部门异常，参数：{}", dept, e);
            throw new BusinessException("更新部门失败");
        }
    }

}
