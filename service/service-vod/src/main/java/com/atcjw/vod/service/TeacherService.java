package com.atcjw.vod.service;

import com.atcjw.model.vod.Teacher;
import com.atcjw.vod.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public List<Teacher> queryAllTeacher() {
        return teacherDao.queryAllTeacher();
    }

    public int deleteTeacher(long id) {
        return teacherDao.deleteTeacher(id);
    }
}
