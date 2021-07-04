package com.soul.dao;

import com.soul.pojo.User;
import com.soul.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void testGetUserList() {
        // 1. 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2. 执行SQL
        // 方式一：getMapper （目前比较流行的）
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        // 方式二：(原来的，现在不常用了)
//        List<User> userList = sqlSession.selectList("com.soul.dao.UserDao.getUserList");
        for (User user : userList) {
            System.out.println(user);
        }

        // 3. 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByID(3, "李四");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5, "xiaoming", "123");
        userMapper.addUser(user);
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5, "xiaohong", "321");
        userMapper.updateUser(user);
        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(5);
        sqlSession.close();
    }

}
