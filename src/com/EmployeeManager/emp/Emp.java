package com.EmployeeManager.emp;

import java.util.Date;


public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;

    private String hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;


    //部门门名称
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Emp() {
    }

    public Emp(String ename, String job, Integer mgr, String hiredate, Double sal, Double comm, Integer deptno) {
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    /**
     * 获取
     *
     * @return empno
     */
    public Integer getEmpno() {
        return empno;
    }

    /**
     * 设置
     *
     * @param empno
     */
    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    /**
     * 获取
     *
     * @return ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * 设置
     *
     * @param ename
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * 获取
     *
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置
     *
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取
     *
     * @return mgr
     */
    public Integer getMgr() {
        return mgr;
    }

    /**
     * 设置
     *
     * @param mgr
     */
    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    /**
     * 获取
     *
     * @return hiredate
     */
    public String getHiredate() {
        return hiredate;
    }

    /**
     * 设置
     *
     * @param hiredate
     */
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * 获取
     *
     * @return sal
     */
    public Double getSal() {
        return sal;
    }

    /**
     * 设置
     *
     * @param sal
     */
    public void setSal(Double sal) {
        this.sal = sal;
    }

    /**
     * 获取
     *
     * @return comm
     */
    public Double getComm() {
        return comm;
    }

    /**
     * 设置
     *
     * @param comm
     */
    public void setComm(Double comm) {
        this.comm = comm;
    }

    /**
     * 获取
     *
     * @return deptno
     */
    public Integer getDeptno() {
        return deptno;
    }

    /**
     * 设置
     *
     * @param deptno
     */
    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String toString() {
        return "Emp{empno = " + empno + ", ename = " + ename + ", job = " + job + ", mgr = " + mgr + ", hiredate = " + hiredate + ", sal = " + sal + ", comm = " + comm + ", deptno = " + deptno + "}";
    }
}
