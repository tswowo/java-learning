package org.javaweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaweb.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量添加员工工作经历
     */
    public void addEmpExpr(@Param("exprList") List<EmpExpr> exprList);

    /**
     * 根据Id查询员工工作经历
     */
    List<EmpExpr> selectEmpExprById(Integer id);

    /**
     * 新增：根据员工ID删除所有工作经历
     */
    void deleteByEmpId(@Param("empId") Integer empId);
}
