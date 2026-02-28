package org.javaweb.controller;

import org.javaweb.pojo.Result;
import org.javaweb.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/report/empGenderData")
    public Result getEmpGenderData() {
        return Result.success(reportService.getEmpGenderDate());
    }

    @GetMapping("/report/empJobData")
    public Result getEmpJobData() {
        return Result.success(reportService.getEmpJobDate());
    }

    @GetMapping("/report/studentDegreeData")
    public Result getStudentDegreeData() {
        return Result.success(reportService.getStudentDegreeData());
    }

    @GetMapping("/report/studentCountData")
    public Result getStudentCountData() {
        return Result.success(reportService.getStudentCountData());
    }
}
