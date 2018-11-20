package com.aaa.mybatis.test;

import com.aaa.mybatis.dao.DeptDao;
import com.aaa.mybatis.util.SqlSessionFatoryutil;
import org.apache.ibatis.session.SqlSession;
import com.aaa.mybatis.entity.Dept;


import java.util.List;

/**
 * className:DeptDaoTest
 * discriptoin:
 * author:邢博
 * createTime:2018-11-03 16:50
 */
public class DeptDaoTest {

    public static void main(String[] args) {
        //使用工具类获取SqlSession
        SqlSession sqlSession = SqlSessionFatoryutil.createSqlSession();
        //利用SqlSession提供的方法获取接口的实现类  getMapper使用借口和 配置文件实例化 接口的实现类
        DeptDao mapper = sqlSession.getMapper(DeptDao.class);
        //调用接口中方法得到数据
        List<Dept> list = mapper.getList();
        //循环打印
        for (Dept dept : list) {
            System.out.println(dept.getDname());
        }
    }
}
