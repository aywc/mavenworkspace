package com.aaa.mybatis.entity;

import java.util.List;

/**
 * className:Dept
 * discriptoin:部门 实体
 * author:邢博
 * createTime:2018-11-03 16:09
 */
public class Dept {
    private int deptNo;
    private String dname;
    private String loc;
    //员工的集合属性
    private List<Emp> empList;

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
