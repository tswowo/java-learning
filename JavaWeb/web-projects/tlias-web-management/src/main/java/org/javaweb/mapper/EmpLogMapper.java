package org.javaweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaweb.pojo.LogOperator;

@Mapper
public interface EmpLogMapper {
    //插入日志
    public void insert(LogOperator logOperator);
}