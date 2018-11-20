package com.aaa.mybatis.test;

import com.aaa.mybatis.dao.DeptDao;
import com.aaa.mybatis.entity.Dept;
import com.aaa.mybatis.util.SqlSessionFatoryutil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * className:updateTest
 * discriptoin:
 * author:邢博
 * createTime:2018-11-05 16:04
 */
public class updateTest {
    public static void main(String[] args) {
        SqlSession sqlSession =null;
        try {
            //使用工具类获取SqlSession
            sqlSession = SqlSessionFatoryutil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper使用借口和 配置文件实例化 接口的实现类
            DeptDao mapper = sqlSession.getMapper(DeptDao.class);
            Dept dept = mapper.getById(41);
            dept.setDname("kai");
            dept.setLoc("2f");
            int result = mapper.update(dept);
            sqlSession.commit();
            if(result>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
