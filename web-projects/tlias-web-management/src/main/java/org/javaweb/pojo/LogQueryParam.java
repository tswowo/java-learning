package org.javaweb.pojo;

import lombok.Data;

/**
 * 日志查询入参
 */
@Data
public class LogQueryParam {
    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 页大小
     */
    private Integer pageSize = 10;
}