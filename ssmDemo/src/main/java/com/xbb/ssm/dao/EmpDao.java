package com.xbb.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * discriptoin:员工持久层
 * author:zz
 * createTime:2018-11-07 14:59
 */
public interface EmpDao {

    /**
     * 员工列表
     * @return
     */
    List<Map> getPage(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 新增员工
     */
    int addEmp(Map map);

    /**
     * 通过ID查询员工信息
     */
    List<Map> getEmpList(Integer empNo);

    /**
     * 修改
     */
    int updateEmp(Map map);

    /**
     * 删除员工
     */
    int deleteEmp(Integer empNo);

    /**
     * 查询单位编号
     */
    List<Map> getDeptNoList();

}
