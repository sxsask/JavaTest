package com.EmployeeManager.emp;

import com.EmployeeManager.BaseDao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoimpl extends BaseDao implements EmpDao {

    @Override
    public boolean isExistName(String name) {
        boolean flag = false;

        try {

            String sql = "select * from emp where ename=?";
            flag = super.isExist(sql, name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return flag;
    }

    @Override
    public boolean isExistId(int id) {
        boolean exist = false;
        try {
            String sql = "select * from emp where empno=?";
            exist = super.isExist(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return exist;
    }

    @Override
    public int addEmp(Emp emp) {
        int count = 0;
        try {
            super.getConnection();
            if (emp.dept.getDeptno() != 0) {
                String sql = "INSERT INTO emp(ename, job, mgr, hiredate, sal, comm, deptno)  VALUES (?, ?, ?, ?, ?, ?, ?);";
                Object[] params = {emp.getEname(), emp.getJob(), String.valueOf(emp.getMgr()), emp.getHiredate(), String.valueOf(emp.getSal()), String.valueOf(emp.getComm()), emp.dept.getDeptno()};
                count = super.update(sql, params);
            } else {
                String sql = "INSERT INTO emp(ename, job, mgr, hiredate, sal, comm)  VALUES (?, ?, ?, ?, ?, ?);";
                Object[] params = {emp.getEname(), emp.getJob(), String.valueOf(emp.getMgr()), emp.getHiredate(), String.valueOf(emp.getSal()), String.valueOf(emp.getComm())};
                count = super.update(sql, params);

            }


            return count;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public int updateEmp(Emp emp) {
        int count = 0;
        try {
            String sql = "update emp set ename= COALESCE(?,ename),job= COALESCE(?,job),mgr= COALESCE(?,mgr),sal= COALESCE(?,sal),comm= COALESCE(?,comm) where empno=?";
            Object[] params = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getSal(), emp.getComm(), emp.getEmpno()};
            count = super.update(sql, params);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public int deleteEmp(int id) {
        int count = 0;
        try {
            String sql = "delete from emp where empno=?";
            count = super.update(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public List<Emp> getAllEmps() {
        List<Emp> emps = new ArrayList<>();
        try {
            String sql = "select * from emp,dept where dept.deptno = emp.deptno";
            ResultSet query = super.query(sql, null);
            return getEmps(emps, query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Emp> getById(int id) {
        List<Emp> emps = new ArrayList<>();
        try {
            String sql = "select * from emp,dept where dept.deptno = emp.deptno and empno=?";
            ResultSet query = super.query(sql, id);
            return getEmps(emps, query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Emp> getEmps(List<Emp> emps, ResultSet query) throws SQLException {
        while (query.next()) {
            Emp emp = new Emp();
            emp.setEmpno(query.getInt("empno"));
            emp.setEname(query.getString("ename"));
            emp.setJob(query.getString("job"));
            emp.setMgr(query.getInt("mgr"));
            emp.setHiredate(query.getString("hiredate"));
            emp.setSal(query.getDouble("sal"));
            emp.setComm(query.getDouble("comm"));
            emp.dept.setDeptno(query.getInt("deptno"));
            emp.dept.setDname(query.getString("dname"));
            emp.dept.setLoc(query.getString("loc"));
            emps.add(emp);
        }
        return emps;
    }


    public List<Emp> getEmpByCondition(String name, Integer dept, String job, String hiredate, String hiredate1, String sal, String sal1) {
        List<Emp> emps = new ArrayList<>();

        try {
            String sql = "select * from emp,dept where dept.deptno = emp.deptno ";
            if (name != null && !"".equals(name)) {
                sql += "and ename like '%" + name + "%'";
            }
            if (dept != null && dept != 0) {
                sql += " and deptno = " + dept;
            }
            if (job != null && !"".equals(job)) {
                sql += " and job = '" + job + "'";
            }
            if (hiredate != null && !"".equals(hiredate)) {
                sql += " and hiredate >= '" + hiredate + "'";
            }
            if (hiredate1 != null && !"".equals(hiredate1)) {
                sql += " and hiredate <= '" + hiredate1 + "'";
            }
            if (sal != null && !"".equals(sal)) {
                sql += " and sal >= " + sal;
            }
            if (sal1 != null && !"".equals(sal1)) {
                sql += " and sal <= " + sal1;
            }
            sql += ";";
            System.out.println(sql);
            //执行sql语句*/
            ResultSet query = super.query(sql);
            while (query.next()) {
                Emp emp = new Emp();
                emp.setEmpno(query.getInt("empno"));
                emp.setEname(query.getString("ename"));
                emp.setJob(query.getString("job"));
                emp.setMgr(query.getInt("mgr"));
                emp.setHiredate(query.getString("hiredate"));
                emp.setSal(query.getDouble("sal"));
                emp.setComm(query.getDouble("comm"));
                emp.dept.setDeptno(query.getInt("deptno"));
                emp.dept.setDname(query.getString("dname"));
                emp.dept.setLoc(query.getString("loc"));
                emps.add(emp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emps;

    }

}

