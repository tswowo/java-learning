package org.javaweb.controller;

import org.javaweb.anno.LogLogin;
import org.javaweb.pojo.Emp;
import org.javaweb.pojo.Result;
import org.javaweb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final EmpService empService;

    @Autowired
    public LoginController(EmpService empService) {
        this.empService = empService;
    }


    /**
     * 登录
     */
    @PostMapping("/login")
    @LogLogin
    public Result login(@RequestBody Emp emp) {
        return empService.login(emp);
    }
}
