package com.atcjw.vod.service;

import com.atcjw.model.vod.Teacher;
import com.atcjw.vo.vod.TeacherQueryVo;
import com.atcjw.vod.dao.TeacherDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public PageInfo<Teacher> page(int pageNo, int pageSize, TeacherQueryVo teacherVo) {
        PageHelper.startPage(pageNo, pageSize);
        List<Teacher> teacherList;
        if (teacherVo == null) {
            teacherList = teacherDao.queryAllTeacher();
        } else {
            teacherList = teacherDao.queryWithVo(teacherVo.getName(), teacherVo.getLevel());
        }
        return new PageInfo<>(teacherList);
    }

    public int insertTeacher(Teacher teacher) {
        return teacherDao.insertTeacher(teacher);
    }

    public Teacher getTeacherById(long id) {
        return teacherDao.queryById(id);
    }

    public int updateTeacher(long id, Teacher teacher) {
        return teacherDao.updateById(id, teacher);
    }

    public int deleteTeacherList(List<Long> ids) {
        return teacherDao.deleteTeacherList(ids);
    }
}
