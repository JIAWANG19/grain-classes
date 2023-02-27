package com.atcjw.order.abandon.service;

import com.atcjw.model.vod.Teacher;
import com.atcjw.order.abandon.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public List<Teacher> queryAllTeacher() {
        return teacherDao.queryAllTeacher();
    }

    public int deleteTeacher(long id) {
        return teacherDao.deleteTeacher(id);
    }

//    public PageInfo<Teacher> page(int pageNo, int pageSize, TeacherQueryVo teacherVo) {
//        if (teacherVo == null) {
//            return PageHelper.startPage(pageNo, pageSize)
//                    .doSelectPageInfo(() -> teacherDao.queryAllTeacher());
//        } else {
//            return PageHelper.startPage(pageNo, pageSize)
//                    .doSelectPageInfo(() -> teacherDao.queryWithVo(teacherVo.getName(), teacherVo.getLevel()));
//        }
//    }

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
