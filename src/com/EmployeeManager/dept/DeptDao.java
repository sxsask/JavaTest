package com.EmployeeManager.dept;

import java.util.List;

public interface DeptDao {
    //添加方法
    public int addDept(Dept dept);

    //删除方法
    public int deleteDept(int id);

    //id修改方法
    public int updateDept(Dept dept);

    //查询方法
    public List<Dept> getAlldepts();

    //根据id查询
    public List<Dept> getById(int id);

    //判断部门名称存在
    public boolean isExistdeptno(int deptno);

    //判断编号下是否有职员信息
    public boolean isExisdept(int deptno);
}
