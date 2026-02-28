package org.javaweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaweb.pojo.LogOption;

import java.util.List;

@Mapper
public interface LogMapper {
    List<LogOption> selectAllLog();
}
