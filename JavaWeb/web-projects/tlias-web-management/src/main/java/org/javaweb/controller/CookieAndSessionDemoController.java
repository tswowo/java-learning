package org.javaweb.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.javaweb.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieAndSessionDemoController {

    @GetMapping("/c1")
    public Result cookieDemo(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("cookieDemo", "cookieValue");
        response.addCookie(cookie);
        return Result.success("Cookie 已设置");
    }

    @GetMapping("/c2")
    public Result cookieDemo2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("cookieDemo".equals(cookie.getName())) {
                return Result.success("Cookie 获取成功：" + cookie.getValue());
            }
        }
        return Result.success("Cookie 获取失败");
    }

    @GetMapping("/s1")
    public Result sessionDemo(HttpServletRequest request) {
        request.getSession().setAttribute("sessionDemo", "sessionValue");
        return Result.success("Session 已设置");
    }

    @GetMapping("/s2")
    public Result sessionDemo2(HttpServletRequest request) {
        Object sessionDemo = request.getSession().getAttribute("sessionDemo");
        return Result.success("Session 获取成功：" + sessionDemo);
    }
}
