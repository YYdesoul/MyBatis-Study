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
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetUserByMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("name", "李四");
        User user = userMapper.getUserByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "小红", "123");
        int res = userMapper.addUser(user);
        if (res > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        // 增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testAddUserByMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userId", 6);
        userMap.put("userName", "小光");
        userMap.put("userPwd", "light");
        userMapper.addUserByMap(userMap);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        user.setpwd("222");
        int i = userMapper.updateUser(user);
        if (i > 0) {
            System.out.println("successfully updated");
        } else {
            System.out.println("update failed");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteById(2);
        if (i > 0) {
            System.out.println("successfully deleted");
        } else {
            System.out.println("delete failed");
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
