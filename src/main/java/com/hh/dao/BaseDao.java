package com.hh.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 15-9-27.
 */
@Component
public class BaseDao {
    @Autowired
    public SqlSessionTemplate sqlSessionTemplate;

    public List getList(String statementId, Object parameter){
        return sqlSessionTemplate.selectList(statementId,parameter);
    }
}
