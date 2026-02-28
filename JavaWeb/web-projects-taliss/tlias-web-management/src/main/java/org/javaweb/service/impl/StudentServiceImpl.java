package org.javaweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.javaweb.mapper.StudentMapper;
import org.javaweb.pojo.*;
import org.javaweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result getStudentListByCondition(StudentQueryParam param) {
        log.info("【学生管理】接收到学生列表查询请求，查询参数：{}", param);

        try {
            if (param == null) {
                param = new StudentQueryParam();
                log.info("【学生管理】查询参数为空，初始化默认查询参数对象");
            }

            // 处理参数，空字符串转为null
            param.setName(param.getName() == null || param.getName().trim().equals("") ? null : param.getName());
            log.info("【学生管理】参数预处理完成，处理后参数：{}", param);

            // 开启分页
            PageHelper.startPage(param.getPage(), param.getPageSize());
            log.info("【学生管理】分页参数处理完成，当前页码：{}，每页条数：{}", param.getPage(), param.getPageSize());

            // 执行查询
            List<Student> students = studentMapper.selectByCondition(param);
            log.info("【学生管理】学生条件查询执行完成，查询到{}条数据", students.size());

            // 封装分页结果
            PageInfo<Student> pageInfo = new PageInfo<>(students);
            PageResult<Student> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
            log.info("【学生管理】分页结果封装完成，总记录数：{}，当前页数据条数：{}", pageInfo.getTotal(), pageInfo.getList().size());


            return Result.success(pageResult);
        } catch (Exception e) {
            log.error("【学生管理】学生列表查询异常，参数：{}", param, e);
            throw e;
        }
    }

    @Override
    public Result deleteStudentByIds(Integer[] ids) {
        log.info("【学生管理】接收到学生删除请求，待删除学生ID：{}", Arrays.toString(ids));

        try {
            if (ids == null || ids.length == 0) {
                log.warn("【学生管理】学生删除失败：未传入任何学生ID");
                throw new BusinessException("请选择要删除的记录");
            }

            studentMapper.deleteStudentByIds(ids);
            log.info("【学生管理】批量删除学生完成，总计删除{}条记录", ids.length);


            return Result.success("学生删除成功");
        } catch (Exception e) {
            log.error("【学生管理】批量删除学生异常，待删除ID：{}", Arrays.toString(ids), e);
            throw e;
        }
    }

    @Override
    public Result addStudent(Student student) {
        log.info("【学生管理】接收到学生新增请求，学生信息：{}", student);

        try {
            studentMapper.addStudent(student);
            log.info("【学生管理】学生添加成功，学生信息：{}", student);


            return Result.success("学生新增成功");
        } catch (Exception e) {
            log.error("【学生管理】学生新增异常，学生信息：{}", student, e);
            throw e;
        }
    }

    @Override
    public Result selectById(Integer id) {
        log.info("【学生管理】接收到学生详情查询请求，查询学生ID：{}", id);

        try {
            if (id == null) {
                log.warn("【学生管理】学生详情查询失败：未传入学生ID");
                throw new BusinessException("请选择要查询的记录");
            }

            Student student = studentMapper.selectById(id);
            if (student == null) {
                log.warn("【学生管理】学生详情查询：ID为{}的学生不存在", id);
                throw new BusinessException("查询的学生不存在");
            }

            log.info("【学生管理】学生ID：{} 详情查询完成", id);


            return Result.success(student);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("【学生管理】学生详情查询异常，学生ID：{}", id, e);
            throw e;
        }
    }

    @Override
    public Result updateStudent(Student student) {
        log.info("【学生管理】接收到学生更新请求，待更新学生信息：{}", student);

        try {
            if (student == null || student.getId() == null) {
                log.warn("【学生管理】更新学生失败：参数为空或未传入学生ID");
                throw new BusinessException("请选择要修改的记录");
            }

            studentMapper.updateStudent(student);
            log.info("【学生管理】学生信息更新成功，学生ID：{}", student.getId());


            return Result.success("学生信息更新成功");
        } catch (Exception e) {
            log.error("【学生管理】学生更新执行异常，学生ID：{}", student.getId(), e);
            throw e;
        }
    }

    @Override
    public Result updateStudentViolation(Integer id, Short score) {
        log.info("【学生管理】接收到学生违纪扣分更新请求，学生ID：{}，扣分：{}", id, score);

        try {
            if (id == null || score == null) {
                log.warn("【学生管理】参数不能为空");
                throw new BusinessException("参数不能为空");
            }

            Student student = studentMapper.selectById(id);
            if (student == null) {
                log.warn("【学生管理】未找到对应ID的记录，学生ID：{}", id);
                throw new BusinessException("未找到对应ID的记录");
            }

            student.setViolationScore((short) (student.getViolationScore() + score));
            student.setViolationCount((short) (student.getViolationCount() + 1));
            studentMapper.updateStudentViolation(student);


            return Result.success("学生违纪扣分更新成功");
        } catch (Exception e) {
            log.error("【学生管理】学生违纪扣分更新异常，学生ID：{}，扣分：{}", id, score, e);
            throw e;
        }
    }
}
