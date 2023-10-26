package com.EmployeeManager.emp;

import java.util.List;

public interface EmpDao {
    //对员工姓名进行唯一判断
    public boolean isExistName(String name);

    //对员工工号进行唯一判断
    public boolean isExistId(int id);

    //添加数据方法
    public int addEmp(Emp emp);

    //修改方法
    public int updateEmp(Emp emp);

    //删除方法
    public int deleteEmp(int id);

    //查询询方法
    public List<Emp> getAllEmps();


    //根据id查询职业信息
    public List<Emp> getById(int id);

}
