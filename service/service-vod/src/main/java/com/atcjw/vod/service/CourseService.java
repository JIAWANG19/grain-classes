package com.atcjw.vod.service;

import com.atcjw.model.vod.Course;
import com.atcjw.vo.vod.CourseFormVo;
import com.atcjw.vo.vod.CoursePublishVo;
import com.atcjw.vo.vod.CourseQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


public interface CourseService extends IService<Course> {
    Page<Course> pageQuery(Page<Course> pageParam, CourseQueryVo courseQueryVo);

    Long saveCourseInfo(CourseFormVo courseFormVo);

    CourseFormVo getInfoById(long id);

    boolean updateCourseInfo(CourseFormVo courseFormVo);

    CoursePublishVo getCoursePublishVo(Long id);

    boolean publishCourse(Long id);
}
