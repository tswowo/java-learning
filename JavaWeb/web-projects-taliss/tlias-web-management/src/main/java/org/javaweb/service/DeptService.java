package org.javaweb.service;

import org.javaweb.pojo.Dept;
import org.javaweb.pojo.Result;

public interface DeptService {
    public Result selectAllDept();

    public Result selectByDept(Dept dept);

    public Result selectById(Integer id);

    public Result deleteById(Integer id);

    public Result addDept(Dept dept);

    public Result updateDept(Dept dept);
}
