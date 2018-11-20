
import com.aaa.mybatis.dao.DeptDao;
import com.aaa.mybatis.util.SqlSessionFatoryutil;
import org.apache.ibatis.session.SqlSession;

/**
 * className:deleteTest
 * discriptoin:
 * author:邢博
 * createTime:2018-11-05 16:13
 */
public class deleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession =null;
        try {
            //使用工具类获取SqlSession
            sqlSession = SqlSessionFatoryutil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper使用借口和 配置文件实例化 接口的实现类
            DeptDao mapper = sqlSession.getMapper(DeptDao.class);
            int result = mapper.delete(43);
            sqlSession.commit();
            if(result>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
