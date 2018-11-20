
import com.aaa.mybatis.dao.DeptDao;
import com.aaa.mybatis.entity.Dept;
import com.aaa.mybatis.entity.Emp;
import com.aaa.mybatis.util.SqlSessionFatoryutil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


/**
 * className:addTest
 * discriptoin:
 * author:邢博
 * createTime:2018-11-05 14:47
 */
public class addTest {

    @Test
    public void addTest(){

        SqlSession sqlSession =null;
        try {
            //使用工具类获取SqlSession
            sqlSession=SqlSessionFatoryutil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper使用借口和 配置文件实例化 接口的实现类
            DeptDao mapper = sqlSession.getMapper(DeptDao.class);
            Dept dept1 = new Dept();
            //dept1.setDeptNo(21);
            dept1.setDname("kaifa");
            dept1.setLoc("1f");
            int result = mapper.add(dept1);
            sqlSession.commit();
            if(result>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testOneToMany(){
            SqlSession sqlSession =null;
        try {
            //使用工具类获取SqlSession
            sqlSession=SqlSessionFatoryutil.createSqlSession();
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
