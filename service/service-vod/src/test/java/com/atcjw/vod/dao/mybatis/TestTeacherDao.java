package com.atcjw.vod.dao.mybatis;

import com.atcjw.model.vod.Teacher;
import com.atcjw.vod.dao.BaseDaoTest;
import com.atcjw.vod.dao.TeacherMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestTeacherDao implements BaseDaoTest {
    @Autowired
    TeacherMapper teacherMapper;

    @Test
    public void test() {
        List<Teacher> teacherList = teacherMapper.selectList(null);
        teacherList.forEach(System.out::println);
    }

    @Test
    public void testDelete() {
        int i = teacherMapper.deleteById(1110);
        System.out.println(i);
    }
}
