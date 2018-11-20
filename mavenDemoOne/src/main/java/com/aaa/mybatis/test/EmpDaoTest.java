
import com.aaa.mybatis.dao.EmpDao;
import com.aaa.mybatis.util.SqlSessionFatoryutil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:EmpDaoTest
 * discriptoin:
 * author:邢博
 * createTime:2018-11-05 16:49
 */
public class EmpDaoTest {

    /**
     * 获取员工列表
     */
    @Test
    public void testGetList(){
        SqlSession sqlSession =null;
        try {
            sqlSession=SqlSessionFatoryutil.createSqlSession();
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            Map paramMap = new HashMap();
            paramMap.put("job","CLERK");
            paramMap.put("startDate","1981-01-01");
            paramMap.put("endDate","1987-01-01");
            List<Map> list = mapper.getList(paramMap);
            for (Map map : list) {
                System.out.println("员工编号："+map.get("EMPNO")+",员工姓名："+map.get("ENAME")+",员工职位："+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    /**
     * 获取员工列表
     */
    @Test
    public void testGetListByParam(){
        SqlSession sqlSession =null;
        try {
            sqlSession=SqlSessionFatoryutil.createSqlSession();
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            Map paramMap = new HashMap();
            //paramMap.put("job","CLERK");
            //paramMap.put("startDate","1981-01-01");
            List<Map> list = mapper.getListByParam(paramMap);
            for (Map map : list) {
                System.out.println("员工编号："+map.get("EMPNO")+",员工姓名："+map.get("ENAME")+",员工职位："+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 获取员工列表
     */
    @Test
    public void getListByList(){
        SqlSession sqlSession =null;
        try {
            sqlSession=SqlSessionFatoryutil.createSqlSession();
            EmpDao mapper = sqlSession.getMapper(EmpDao.class);
            List paramList = new ArrayList();
            paramList.add(7369);
            paramList.add(7900);
            paramList.add(7654);
            paramList.add(7566);
            List<Map> list = mapper.getListByList(paramList);
            for (Map map : list) {
                System.out.println("员工编号："+map.get("EMPNO")+",员工姓名："+map.get("ENAME")+",员工职位："+map.get("JOB"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

}
