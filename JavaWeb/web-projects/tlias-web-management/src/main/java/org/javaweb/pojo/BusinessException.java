package org.javaweb.pojo;

import lombok.Getter;

/**
 * 自定义业务异常
 */
@Getter
public class BusinessException extends RuntimeException {

    private final int code; // 错误码
    private final String message;

    // 重载构造方法，默认错误码400
    public BusinessException(String message) {
        super(message);
        this.code = 400;
        this.message = message;
    }

    // 自定义错误码
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}