package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogOperator {
    private Integer id;
    private Integer operateEmpId;
    private LocalDateTime operateTime;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private Long costTime;
}
