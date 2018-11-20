package com.aaa.mybatis.dao;

import com.aaa.mybatis.entity.Dept;

import java.util.List;

/**
 * className:Dept
 * discriptoin:部门接口
 * author:邢博
 * createTime:2018-11-03 16:09
 */
public interface DeptDao {
    /**
     * 获取部门列表
     * @return
     */
    List<Dept> getList();
    /**
     *
     * 部门添加
     */
    int add(Dept dept);

    /**
     * 根据部门编号查询信息
     * @param deptNo
     * @return
     */
    Dept getById(int deptNo);

    /**
     * 更新
     * @param dept
     * @return
     */
    int update(Dept dept);

    /**
     * 删除
     * @param deptNo
     * @return
     */
    int delete(int deptNo);

    /**
     * mybatis高级映射一对多
     * @return
     */
    List<Dept> oneToMany();
}
