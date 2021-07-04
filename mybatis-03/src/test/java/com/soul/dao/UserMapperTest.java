package com.soul.dao;

import com.soul.dao.UserMapper;
import com.soul.pojo.User;
import com.soul.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

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
    public void testLog4j() {
        logger.info("info: 进入了testLog4j方法");
        logger.debug("debug: 进入了testLog4j方法");
        logger.error("error: 进入了testLog4j方法");
    }

}
