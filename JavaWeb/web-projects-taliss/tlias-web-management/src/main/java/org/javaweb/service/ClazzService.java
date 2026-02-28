package org.javaweb.service;

import org.javaweb.pojo.Clazz;
import org.javaweb.pojo.ClazzQueryParam;
import org.javaweb.pojo.Result;

public interface ClazzService {
    Result getClazzListByCondition(ClazzQueryParam param);

    Result deleteClazz(Integer id);

    Result addClazz(Clazz clazz);

    Result getClazzById(Integer id);

    Result updateClazz(Clazz clazz);
}
