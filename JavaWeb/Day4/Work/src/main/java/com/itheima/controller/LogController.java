package com.itheima.controller;

import com.itheima.pojo.Log;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/logs")
    private Result list() {
        List<Log> logList = logService.parseLog();
        return Result.success(logList);
    }

}
