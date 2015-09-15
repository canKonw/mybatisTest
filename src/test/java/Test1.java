import com.hh.entity.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by huhao on 15-9-15.
 */
public class Test1 {
    private SqlSessionFactory sqlSessionFactory = null;

    //创建工厂
    @Before
    public void before() throws IOException {
        //创建会话工厂
        String resource = "SqlMapConfig.xml";
        InputStream in = null;
        in = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);


    }

    @Test
    public void testGet() {
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        User user = sqlSession.selectOne("UserMapper.getUserById", 1);
        System.out.println(user.getUserName());
        sqlSession.close();
    }

    @Test
    public void getListByList(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List listIds = new ArrayList();
        listIds.add(1);
        listIds.add(25);
        listIds.add(26);
        listIds.add(27);
        List<User> lists = sqlSession.selectList("UserMapper.getListByList",listIds);
        for(User user:lists){
            System.out.println(user.toString());
        }
    }

    @Test
    public void getListByMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<String> listIds = new ArrayList<String>();
        listIds.add("1");
        listIds.add("25");
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        map.put("mapsIds",listIds);
        listIds.add("26");
        map.put("mapsIdsTwo",listIds);
        List<User> lists = sqlSession.selectList("UserMapper.getListByMap",map);
        for(User user:lists){
            System.out.println(user.toString());
        }
    }
    @Test
    public void testSelect() {
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        List<User> userList = sqlSession.selectList("UserMapper.findUserByName", "小");
        System.out.println(userList.size());
        for (User user : userList) {
            System.out.println(user.getUserName());
        }
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("杨长用");
        user.setAddress("重庆");
        user.setBirthday(new Date());
        user.setSex("1");
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        sqlSession.insert("UserMapper.insertUser", user);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("--------" + user.getId());
    }

    @Test
    public void testDel() {
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        sqlSession.insert("UserMapper.deleteUser", 27);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserName("杨长用修改");
        user.setAddress("重庆");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setId(27);
        //1通过sqlsessionfactory创建sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        sqlSession.insert("UserMapper.updateUser", user);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("--------" + user.getId());
    }
}
