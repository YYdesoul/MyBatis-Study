package com.soul.dao;

import com.soul.pojo.User;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 获取全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

    User getUserByMap(Map<String, Object> map);

    // insert一个用户
    int addUser(User user);

    // 用Mapinsert用户
    int addUserByMap(Map<String, Object> map);

    int updateUser(User user);

    int deleteById(int id);
}
