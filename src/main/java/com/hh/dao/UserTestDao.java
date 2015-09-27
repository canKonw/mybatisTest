package com.hh.dao;

import com.hh.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 15-9-27.
 */
@Component
public class UserTestDao extends BaseDao {

    public List<User> getAllUser(){
        return this.getList("UserMapper.getAllUser",null);
    }
}
