package org.javaweb.exception;

import lombok.extern.slf4j.Slf4j;
import org.javaweb.pojo.BusinessException;
import org.javaweb.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器：统一捕获所有未处理的异常，封装成标准Result返回
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义业务异常（核心）
     */
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        log.error("业务异常：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 处理系统异常（兜底）
     */
    @ExceptionHandler(Exception.class)
    public Result handleSystemException(Exception e) {
        log.error("系统异常", e); // 打印完整堆栈，方便排查
        return Result.error("系统内部错误，请联系管理员");
    }
}