package com.soul.dao;

import com.soul.pojo.User;
import com.soul.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TestMapper {

    @Test
    public void TestQueryUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.queryUserById(1);
        System.out.println("===============");
        User user2 = userMapper.queryUserById(1);
        System.out.println(user1 == user2);
        sqlSession.close();
    }

    @Test
    public void testQueryUserById(){
        SqlSession session = MybatisUtils.getSqlSession();
        SqlSession session2 = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);
        session.close();
        session2.close();
    }

    @Test
    public void testQueryUserById2(){
        SqlSession session = MybatisUtils.getSqlSession();
        SqlSession session2 = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);
        session2.close();
    }
}
