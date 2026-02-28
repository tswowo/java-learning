package org.javaweb.service;

import org.javaweb.pojo.Emp;
import org.javaweb.pojo.EmpQueryParam;
import org.javaweb.pojo.Result;

public interface EmpService {

    Result selectEmpByCondition(EmpQueryParam param);

    Result deleteEmp(Integer[] ids);

    Result addEmp(Emp emp);

    Result selectById(Integer id);

    Result updateEmp(Emp emp);

    Result selectAllEmp();

    Result login(Emp emp);
}
