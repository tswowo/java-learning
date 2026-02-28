package org.javaweb.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.javaweb.pojo.Emp;
import org.javaweb.pojo.EmpQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    /**
     * 多条件分页查询员工列表
     */
    List<Emp> selectEmpByCondition(EmpQueryParam param);

    /**
     * 根据id删除员工
     */
    void deleteById(Integer id);

    /**
     * 添加员工
     */
    void addEmp(Emp emp);

    /**
     * 根据id查询员工
     */
    Emp selectById(Integer id);

    /**
     * 修改员工
     */
    void updateEmp(Emp emp);

    /**
     * 根据用户名查询员工
     */
    Emp selectByUsername(String username);

    /**
     * 获取员工职位数据统计
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 获取员工性别数据统计
     */
    List<Map<String, Object>> countEmpGenderData();

    /**
     * 获取学生学历数据统计
     */
    List<Map<String, Object>> countStudentDegreeData();

    /**
     * 获取学生数量数据统计
     */
    List<Map<String, Object>> countStudentCountData();

    /**
     * 根据用户名和密码查询员工
     */
    Emp selectByUsernameAndPassword(Emp emp);
}