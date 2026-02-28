package org.javaweb.controller;

import org.javaweb.anno.LogOperation;
import org.javaweb.pojo.Clazz;
import org.javaweb.pojo.ClazzQueryParam;
import org.javaweb.pojo.Result;
import org.javaweb.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClazzController {
    final ClazzService clazzService;

    @Autowired
    public ClazzController(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    /**
     * 查询班级列表
     */
    @GetMapping("/clazzs")
    public Result getClazzListByCondition(@ModelAttribute ClazzQueryParam clazzQueryParam) {
        return clazzService.getClazzListByCondition(clazzQueryParam);
    }

    /**
     * 删除班级
     */
    @DeleteMapping("/clazzs/{id}")
    @LogOperation
    public Result deleteClazz(@PathVariable Integer id) {
        return clazzService.deleteClazz(id);
    }

    /**
     * 添加班级
     */
    @PostMapping("/clazzs")
    @LogOperation
    public Result addClazz(@RequestBody Clazz clazz) {
        return clazzService.addClazz(clazz);
    }

    /**
     * 根据ID查询班级
     */
    @GetMapping("/clazzs/{id}")
    public Result getClazzById(@PathVariable Integer id) {
        return clazzService.getClazzById(id);
    }


    /**
     * 修改班级
     */
    @PutMapping("/clazzs")
    @LogOperation
    public Result updateClazz(@RequestBody Clazz clazz) {
        return clazzService.updateClazz(clazz);
    }

    /**
     * 查询全部班级列表
     */
    @GetMapping("/clazzs/list")
    public Result getClazzList() {
        return clazzService.getClazzListByCondition(null);
    }
}
