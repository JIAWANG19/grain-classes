//package com.atcjw.vod.dao.mybatis;
//
//import com.atcjw.model.vod.Teacher;
//import com.atcjw.vod.abandon.dao.TeacherDao;
//import com.atcjw.vod.dao.TestBaseDao;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestTeacherDao implements TestBaseDao {
//    @Autowired
//    TeacherDao teacherDao;
//
//    @Test
//    public void testQueryAllTeacher() {
//        List<Teacher> teachers = teacherDao.queryAllTeacher();
//        teachers.forEach(System.out::println);
//    }
//
//    @Test
//    public void testUpdateNameById() {
//        int message = teacherDao.updateNameById("李老师12", 2);
//        System.out.println(message);
//    }
//
//    @Test
//    public void testDeleteTeacher() {
//        int message = teacherDao.deleteTeacher(5);
//        assert message == 1;
//    }
//
//    @Test
//    public void testQueryWithVo() {
//        List<Teacher> teacherList = teacherDao.queryWithVo("老师", 1);
//        teacherList.forEach(System.out::println);
//    }
//
//    @Test
//    public void testQueryById() {
//        Teacher teacher = teacherDao.queryById(2);
//        System.out.println(teacher);
//    }
//
//    @Test
//    public void testInsertTeacher() {
//        Teacher teacher = new Teacher();
//        teacher.setName("曹老师");
//        teacher.setLevel(2);
//        teacher.setSort(0);
//        teacher.setIntro("特级讲师");
//        teacher.setCareer("特级讲师");
//        int message = teacherDao.insertTeacher(teacher);
//        assert message == 1;
//    }
//
//    @Test
//    public void testUpdateById() {
//        Teacher teacher = new Teacher();
//        teacher.setName("曹老师");
//        teacher.setLevel(2);
//        teacher.setSort(0);
//        teacher.setIntro("特级讲师");
//        teacher.setCareer("特级讲师");
//        int message = teacherDao.updateById(5, teacher);
//        assert message == 1;
//    }
//
//    @Test
//    public void testDeleteTeacherList() {
//        List<Long> ids = new ArrayList<Long>() {{
//            add(4L);
//            add(5L);
//            add(6L);
//        }};
//        int result = teacherDao.deleteTeacherList(ids);
//        assert result == ids.size();
//    }
//}
