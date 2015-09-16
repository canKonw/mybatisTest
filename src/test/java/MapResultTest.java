import com.hh.entity.Orders;
import com.sun.deploy.util.OrderedHashSet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by huhao on 15-9-16.
 */
public class MapResultTest {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void init() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 返回对象  对象中包含一个对象
     */
    @Test
   public void getTwoObjectIsObject(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Orders> listOrder = sqlSession.selectList("OrderCustomMapper.getTwoObjectIsObject");
        for(Orders order: listOrder){
            System.out.println("---:"+order.toString());
        }
        sqlSession.close();
   }

    /**
     * 直接返回map形式   若果某个数据为null  map将不会存储该数据
     */
    @Test
    public void getTwoObjectIsMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Map<String,Object>> listObject = sqlSession.selectList("OrderCustomMapper.getTwoObjectIsMap");
        for(Map<String,Object> map : listObject){
            Set<String> sets = map.keySet();
            StringBuffer stringBuffer = new StringBuffer();
            for(String str:sets){
                stringBuffer.append(str).append("--").append(map.get(str));
            }
            System.out.println("--:"+stringBuffer.toString());
        }
    }


}
