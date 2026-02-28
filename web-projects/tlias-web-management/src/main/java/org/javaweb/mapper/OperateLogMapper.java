package org.javaweb.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.javaweb.pojo.EmpLoginLog;
import org.javaweb.pojo.OperateLog;

@Mapper
public interface OperateLogMapper {

    //插入日志数据
    @Insert("INSERT INTO operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "VALUES (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insertOperationLog(OperateLog log);

    @Insert("INSERT INTO emp_login_log (username, password, login_time, cost_time, is_success, jwt) " +
            "VALUES (#{username}, #{password}, #{loginTime}, #{costTime}, #{isSuccess}, #{jwt});"
    )
    public void insertLoginLog(EmpLoginLog log);
}