package org.javaweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 操作日志实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogOption {

    /**
     * 日志主键
     */
    private Long id;

    /**
     * 操作人ID
     */
    private Long operateEmpId;

    /**
     * 操作时间（ISO格式：2023-12-18T17:37:15）
     */
    private String operateTime;

    /**
     * 操作类名
     */
    private String className;

    /**
     * 操作方法名
     */
    private String methodName;

    /**
     * 方法参数
     */
    private String methodParams;

    /**
     * 方法返回值
     */
    private String returnValue;

    /**
     * 方法耗时（毫秒）
     */
    private Long costTime;

    /**
     * 操作人名称
     */
    private String operateEmpName;
}