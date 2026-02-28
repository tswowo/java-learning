package org.javaweb.controller;

import org.apache.ibatis.annotations.Delete;
import org.javaweb.anno.LogOperation;
import org.javaweb.pojo.Result;
import org.javaweb.pojo.Student;
import org.javaweb.pojo.StudentQueryParam;
import org.javaweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Result getStudentListByCondition(@ModelAttribute StudentQueryParam param) {
        return studentService.getStudentListByCondition(param);
    }

    @DeleteMapping("/students/{ids}")
    @LogOperation
    public Result deleteStudentByIds(@PathVariable Integer[] ids) {
        return studentService.deleteStudentByIds(ids);
    }

    @PostMapping("/students")
    @LogOperation
    public Result addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students/{id}")
    public Result getStudentById(@PathVariable Integer id) {
        return studentService.selectById(id);
    }

    @PutMapping("/students")
    @LogOperation
    public Result updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @PutMapping("/students/violation/{id}/{score}")
    @LogOperation
    public Result updateStudentViolation(@PathVariable Integer id, @PathVariable Short score) {
        return studentService.updateStudentViolation(id, score);
    }
}
