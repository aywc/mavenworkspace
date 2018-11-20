package com.aaa.mybatis.dao;


import com.aaa.mybatis.entity.Role;

import java.util.List;

/**
 * className:RoleDao
 * discriptoin:
 * author:zz
 * createTime:2018-11-06 16:58
 */
public interface RoleDao {
    /**
     * 多对多
     * @return
     */
    List<Role> manyToMany();

}
