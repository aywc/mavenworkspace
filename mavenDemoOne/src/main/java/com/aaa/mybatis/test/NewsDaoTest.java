import com.aaa.mybatis.dao.NewsDoa;
import com.aaa.mybatis.entity.Emp;
import com.aaa.mybatis.entity.News;
import com.aaa.mybatis.util.SqlSessionFatoryutil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * className:NewsDaoTest
 * discriptoin:
 * author:邢博
 * createTime:2018-11-06 16:20
 */
public class NewsDaoTest {

    @Test
    public void manyToOne(){
        SqlSession sqlSession =null;
        try {
            //使用工具类获取SqlSession
            sqlSession= SqlSessionFatoryutil.createSqlSession();
            //利用SqlSession提供的方法获取接口的实现类  getMapper使用借口和 配置文件实例化 接口的实现类
            NewsDoa mapper = sqlSession.getMapper(NewsDoa.class);
            List<News> news = mapper.manyToOne();
            if(news!=null&&news.size()>0){
                for (News new1 : news) {
                    System.out.println("新闻标题："+new1.getTitle()+",内容："+new1.getContent()+",分类名称："+new1.getNewsType().getTypeName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
