package com.hh.service;

import com.hh.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 15-9-27.
 */
@Service
public class UserService {
    private SqlSessionFactory sqlSessionFactory;
    public List<User> getUserList(){
        SqlSession sqlSession =sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("UserMapper.getAllUser");
        return  userList;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
