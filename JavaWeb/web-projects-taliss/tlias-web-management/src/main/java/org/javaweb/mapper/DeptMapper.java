package org.javaweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaweb.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    public List<Dept> selectAllDept();

    public Dept selectByDept(Dept dept);

    public Dept selectById(Integer id);

    public Integer deleteById(Integer id);

    public Integer addDept(Dept dept);

    public Integer updateDept(Dept dept);
}
