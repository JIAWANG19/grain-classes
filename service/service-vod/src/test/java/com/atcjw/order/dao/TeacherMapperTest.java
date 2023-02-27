package com.atcjw.order.dao;

import com.atcjw.model.vod.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherMapperTest implements MapperBaseTest {
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
