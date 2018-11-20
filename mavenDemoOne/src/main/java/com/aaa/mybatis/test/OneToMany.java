import com.aaa.mybatis.dao.DeptDao;
import com.aaa.mybatis.entity.Dept;
import com.aaa.mybatis.entity.Emp;
import com.aaa.mybatis.util.SqlSessionFatoryutil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * className:OneToMany
 * discriptoin:
 * author:邢博
 * createTime:2018-11-06 15:25
 */
public class OneToMany {
    @Test
    public void testOneToMany(){
        SqlSession sqlSession =null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFatoryutil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper使用借口和 配置文件实例化 接口的实现类
            DeptDao mapper = sqlSession.getMapper(DeptDao.class);
            List<Dept> list = mapper.oneToMany();
            if(list!=null&&list.size()>0){
                for (Dept dept : list) {
                    System.out.println("部门名称："+dept.getDname()+",位置："+dept.getLoc());
                    List<Emp> empList = dept.getEmpList();
                    if(empList!=null&&empList.size()>0){
                        for (Emp emp : empList) {
                            System.out.println("----------员工姓名："+emp.getEname()+",工资："+emp.getSalary() +
                                    ",奖金："+emp.getComm());
                        }
                    }else{
                        System.out.println("该部门下没有员工");
                    }
                    System.out.println("----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
