package org.javaweb.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.javaweb.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class TokenIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("【员工管理】系统未登录");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("请先登陆系统");
            return false;
        }

        try {
            JWTUtils.parseToken(token);
        } catch (Exception e) {
            log.info("【员工管理】token无效");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("请先登陆系统");
            return false;
        }
        return true;
    }
}
