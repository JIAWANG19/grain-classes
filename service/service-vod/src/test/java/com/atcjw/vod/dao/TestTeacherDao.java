package com.atcjw.vod.dao;

import com.atcjw.model.vod.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestTeacherDao implements BaseDaoTest {
    @Autowired
    TeacherDao teacherDao;

    @Test
    public void testQueryAllTeacher() {
        List<Teacher> teachers = teacherDao.queryAllTeacher();
        assert teachers.size() == 5;
    }

    @Test
    public void testUpdateNameById() {
        int message = teacherDao.updateNameById("李老师12", 2);
        System.out.println(message);
    }

    @Test
    public void testDeleteTeacher() {
        int message = teacherDao.deleteTeacher(1);
        assert message == 1;
    }
}
