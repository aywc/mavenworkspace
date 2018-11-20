package com.aaa.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * className:SqlSessionFatoryutil
 * discriptoin:创建SqlSession的工具类
 * author:邢博
 * createTime:2018-11-03 16:36
 */
public class SqlSessionFatoryutil {
    //保证其他地方不能有空构造
    private SqlSessionFatoryutil(){}

    //私有的静态的属性，，保证只有一个，并且其他地方不能调用
    private static SqlSessionFactory sqlSessionFactory;

    //使用静态块
    static {
        //使用mybatis提供的Resource类读取主配置文件
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        //创建 SqlSessionFactory
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //提供一个对外可以调用的方法，，返回SqlSession
    public static SqlSession createSqlSession(){
        //使用上面的单例模式 产生的工厂类，创建SqlSession
        return sqlSessionFactory.openSession();
    }

}
