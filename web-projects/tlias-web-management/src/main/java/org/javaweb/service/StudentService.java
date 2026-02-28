package org.javaweb.service;

import org.javaweb.pojo.Result;
import org.javaweb.pojo.Student;
import org.javaweb.pojo.StudentQueryParam;

public interface StudentService {
    Result getStudentListByCondition(StudentQueryParam param);

    Result deleteStudentByIds(Integer[] ids);

    Result addStudent(Student student);

    Result selectById(Integer id);

    Result updateStudent(Student student);

    Result updateStudentViolation(Integer id, Short score);
}
