package com.aaa.mybatis.dao;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * discriptoin:员工数据访问类
 * author:zz
 * createTime:2018-11-05 16:40
 */
public interface EmpDao {
    /**
     * 获取员工列表
     * @return
     */
    List<Map> getList(Map map);

    /**
     * 获取员工列表
     */
    List<Map> getListByParam(Map map);

    /**
     * 获取员工列表
     */
    List<Map> getListByList(List list);


}
