package com.atcjw.vod.dao;

import com.atcjw.model.vod.Course;
import com.atcjw.vo.vod.CoursePublishVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class CourseMapperTest implements MapperBaseTest {
    @Autowired
    CourseMapper courseMapper;

    @Test
    public void testSelectList() {
        List<Course> courses = courseMapper.selectList(null);
        courses.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        Course course = new Course();
        course.setTitle("测试添加的标题2");
        course.setSubjectId(2L);
        course.setSubjectParentId(2L);
        course.setCover("没有哦");
        course.setLessonNum(100);
        course.setPrice(new BigDecimal(10000));
        courseMapper.insert(course);
        if (course.getId() != null) {
            System.out.println(course.getId());
        }
    }


    @Test
    public void testSelectPublishVoById() {
        CoursePublishVo coursePublishVo = courseMapper.selectPublishVoById(1L);
        System.out.println(coursePublishVo);
    }
}
