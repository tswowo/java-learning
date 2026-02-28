package org.javaweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaweb.pojo.Clazz;
import org.javaweb.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {
    List<Clazz> selectClazzByCondition(ClazzQueryParam param);

    int deleteClazz(Integer id);

    int insertClazz(Clazz clazz);

    Clazz selectClazzById(Integer id);

    int updateClazz(Clazz clazz);
}
