import com.hh.entity.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by huhao on 15-9-16.
 */
public class OneToMoreTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public  void getOneToMore(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Orders> ordersList = sqlSession.selectList("oneToMore.findOrderAndDetail");
        for(Orders order:ordersList){
            System.out.println("---:"+order.toString());
            System.out.println(order.getOrderdetails().size());
        }
        sqlSession.close();
    }

}
