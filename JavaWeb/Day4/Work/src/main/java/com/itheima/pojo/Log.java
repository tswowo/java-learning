package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private String operateEmpName; //操作人姓名
    private String operateTime; //操作时间
    private String className; //操作类名
    private String methodName; //操作方法名
    private String costTime; //操作耗时
    private String methodParams; //操作方法参数
    private String returnValue; //操作方法返回值
}
