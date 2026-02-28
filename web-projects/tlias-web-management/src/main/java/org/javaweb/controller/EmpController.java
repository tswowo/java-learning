package org.javaweb.controller;

import org.javaweb.anno.LogOperation;
import org.javaweb.pojo.Emp;
import org.javaweb.pojo.EmpQueryParam;
import org.javaweb.pojo.Result;
import org.javaweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {
    final EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    /**
     * 员工列表全部查询
     */
    @GetMapping("/emps/list")
    public Result getAllEmpList() {
        return empService.selectAllEmp();
    }

    /**
     * 员工列表条件查询
     */
    @GetMapping("/emps")
    public Result getEmpList(@ModelAttribute EmpQueryParam param) {
        return empService.selectEmpByCondition(param);
    }

    /**
     * 员工id查询
     */
    @GetMapping("/emps/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        return empService.selectById(id);
    }

    /**
     * 员工删除
     */
    @DeleteMapping("/emps")
    @LogOperation
    public Result deleteEmp(@RequestParam Integer[] ids) {
        return empService.deleteEmp(ids);
    }

    /**
     * 员工添加
     */
    @PostMapping("/emps")
    @LogOperation
    public Result addEmp(@RequestBody Emp emp) {
        return empService.addEmp(emp);
    }

    /**
     * 员工修改
     */
    @PutMapping("/emps")
    @LogOperation
    public Result updateEmp(@RequestBody Emp emp) {
        return empService.updateEmp(emp);
    }
}
