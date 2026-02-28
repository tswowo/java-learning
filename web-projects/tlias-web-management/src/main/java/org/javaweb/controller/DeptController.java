package org.javaweb.controller;

import org.javaweb.anno.LogOperation;
import org.javaweb.pojo.Dept;
import org.javaweb.pojo.Result;
import org.javaweb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptController {
    final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    /**
     * 部门列表查询
     */
    @GetMapping("/depts")
    public Result getList() {
        return deptService.selectAllDept();
    }

    /**
     * 部门id查询
     */
    @GetMapping("/depts/{id}")
    public Result selectById(@PathVariable Integer id) {
        return deptService.selectById(id);
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/depts")
    @LogOperation
    public Result deleteById(@RequestParam Integer id) {
        return deptService.deleteById(id);
    }

    /**
     * 添加部门
     */
    @PostMapping("/depts")
    @LogOperation
    public Result addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    /**
     * 修改部门
     */
    @PutMapping("/depts")
    @LogOperation
    public Result updateDept(@RequestBody Dept dept) {
        return deptService.updateDept(dept);
    }
}
