package org.javaweb.controller;

import org.javaweb.pojo.LogQueryParam;
import org.javaweb.pojo.Result;
import org.javaweb.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/log/page")
    public Result selectLogPage(@ModelAttribute LogQueryParam param) {
        return logService.selectLogPage(param);
    }
}
