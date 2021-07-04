package com.soul.dao;

import com.soul.pojo.Student;
import com.soul.pojo.Teacher;
import com.soul.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMapper {


    @Test
    public void testGetTeacher() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
