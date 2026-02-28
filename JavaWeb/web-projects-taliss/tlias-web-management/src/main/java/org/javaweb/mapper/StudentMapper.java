package org.javaweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaweb.pojo.Student;
import org.javaweb.pojo.StudentQueryParam;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> selectByCondition(StudentQueryParam param);

    void deleteStudentByIds(Integer[] ids);

    void addStudent(Student student);

    Student selectById(Integer id);

    void updateStudent(Student student);

    void updateStudentViolation(Student student);
}
