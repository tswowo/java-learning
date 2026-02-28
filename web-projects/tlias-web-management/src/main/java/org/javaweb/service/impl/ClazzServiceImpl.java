package org.javaweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.javaweb.pojo.BusinessException;
import org.javaweb.mapper.ClazzMapper;
import org.javaweb.pojo.*;
import org.javaweb.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClazzServiceImpl implements ClazzService {
    final ClazzMapper clazzMapper;

    @Autowired
    public ClazzServiceImpl(ClazzMapper clazzMapper) {
        this.clazzMapper = clazzMapper;
    }

    /**
     * 查询班级列表（兼容接口返回Result，异常抛给全局处理器）
     */
    @Override
    public Result getClazzListByCondition(ClazzQueryParam param) {
        // 开始计时
        log.info("【班级管理】接收到班级列表查询请求，查询参数：{}", param);

        try {
            if (param == null) {
                param = new ClazzQueryParam();
                log.info("【班级管理】查询参数为空，初始化默认查询参数对象");
            }

            // 处理参数，空字符串转为null
            param.setName(param.getName() == null || param.getName().trim().isEmpty() ? null : param.getName());
            log.info("【班级管理】参数预处理完成，处理后参数：{}", param);

            // 开启分页
            PageHelper.startPage(param.getPage(), param.getPageSize());
            log.info("【班级管理】分页参数处理完成，当前页码：{}，每页条数：{}", param.getPage(), param.getPageSize());

            // 执行查询
            List<Clazz> clazzList = clazzMapper.selectClazzByCondition(param);
            log.info("【班级管理】班级条件查询执行完成，查询到{}条数据", clazzList.size());

            // 封装分页结果
            PageInfo<Clazz> pageInfo = new PageInfo<>(clazzList);
            PageResult<Clazz> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
            log.info("【班级管理】分页结果封装完成，总记录数：{}，当前页数据条数：{}", pageInfo.getTotal(), pageInfo.getList().size());


            return Result.success(pageResult);
        } catch (Exception e) {
            log.error("【班级管理】班级列表查询异常，参数：{}", param, e);
            throw e; // 抛出异常交由全局处理器处理
        }
    }

    /**
     * 删除班级（兼容接口，错误抛异常）
     */
    @Override
    public Result deleteClazz(Integer id) {
        // 开始计时
        log.info("【班级管理】接收到班级删除请求，待删除班级ID：{}", id);

        try {
            if (id == null) {
                log.warn("【班级管理】班级删除失败：班级ID为空");
                throw new BusinessException("班级ID不能为空");
            }

            int count = clazzMapper.deleteClazz(id);
            if (count == 0) {
                log.warn("【班级管理】班级删除失败：未找到对应ID的班级，ID：{}", id);
                throw new BusinessException("删除班级失败：未找到对应ID的班级");
            }

            log.info("【班级管理】班级删除成功，ID：{}", id);
            return Result.success();
        } catch (Exception e) {
            log.error("【班级管理】班级删除异常，ID：{}", id, e);
            throw e;
        }
    }

    /**
     * 添加班级（兼容接口，错误抛异常）
     */
    @Override
    public Result addClazz(Clazz clazz) {
        log.info("【班级管理】接收到班级新增请求，班级信息：{}", clazz);

        try {
            int count = clazzMapper.insertClazz(clazz);
            if (count == 0) {
                log.warn("【班级管理】班级新增失败：数据库插入无影响行数，班级信息：{}", clazz);
                throw new BusinessException("添加班级失败：数据库插入无影响行数");
            }

            log.info("【班级管理】班级添加成功，班级信息：{}", clazz);
            return Result.success();
        } catch (Exception e) {
            log.error("【班级管理】班级新增异常，班级信息：{}", clazz, e);
            throw e;
        }
    }

    /**
     * 根据ID查询班级（兼容接口，错误抛异常）
     */
    @Override
    public Result getClazzById(Integer id) {
        log.info("【班级管理】接收到班级ID查询请求，查询参数：{}", id);

        try {
            Clazz clazz = clazzMapper.selectClazzById(id);
            if (clazz == null) {
                log.warn("【班级管理】班级查询失败：未找到对应ID的班级，ID：{}", id);
                throw new BusinessException("查询班级失败：未找到对应ID的班级");
            }

            log.info("【班级管理】班级查询成功，查询结果：{}", clazz);
            return Result.success(clazz);
        } catch (Exception e) {
            log.error("【班级管理】班级查询异常，ID：{}", id, e);
            throw e;
        }
    }

    /**
     * 修改班级（兼容接口，错误抛异常）
     */
    @Override
    public Result updateClazz(Clazz clazz) {
        log.info("【班级管理】接收到班级修改请求，修改参数：{}", clazz);

        try {
            Clazz existClazz = clazzMapper.selectClazzById(clazz.getId());
            if (existClazz == null) {
                log.warn("【班级管理】班级修改失败：班级不存在，ID：{}", clazz.getId());
                throw new BusinessException("班级不存在");
            }

            int count = clazzMapper.updateClazz(clazz);
            if (count == 0) {
                log.warn("【班级管理】班级修改失败：未找到对应ID的班级或数据无变更，班级信息：{}", clazz);
                throw new BusinessException("修改班级失败：未找到对应ID的班级或数据无变更");
            }

            log.info("【班级管理】班级修改成功，班级信息：{}", clazz);
            return Result.success();
        } catch (Exception e) {
            log.error("【班级管理】班级修改异常，班级信息：{}", clazz, e);
            throw e;
        }
    }

}
