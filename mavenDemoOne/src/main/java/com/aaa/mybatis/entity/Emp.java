package com.aaa.mybatis.entity;

/**
 * className:Emp
 * discriptoin:
 * author:邢博
 * createTime:2018-11-06 14:43
 */
public class Emp {
    private Integer empNo;
    private String ename;
    private double salary;
    private String job;
    private double comm;

    public Emp() {
    }

    public Emp(Integer empNo, String ename, double salary, String job, double comm) {
        this.empNo = empNo;
        this.ename = ename;
        this.salary = salary;
        this.job = job;
        this.comm = comm;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }
}
