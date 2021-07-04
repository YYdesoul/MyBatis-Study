package com.soul.dao;

import com.soul.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 获取全部用户
    @Select("select * from user")
    List<User> getUserList();

    // 方法存在多个参数，所有参数前面必须加上@Param("var")注解
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id, @Param("name") String name);

    @Insert("insert into user (id, name, pwd) values (#{id}, #{name}, #{pwd});")
    int addUser(User user);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id};")
    int updateUser(User user);

    @Delete("delete from user where id = #{id};")
    int deleteUser(@Param("id") int id);


}
