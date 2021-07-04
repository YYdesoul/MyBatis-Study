package com.soul.dao;

import com.soul.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher;")
    Teacher getAllTeacher();

    // 获取指定老师下的所有学生及老师的信息
    Teacher getTeacher(@Param("tid") int id);
}
