package com.atcjw.vod.service.impl;

import com.atcjw.model.vod.CourseDescription;
import com.atcjw.vod.dao.CourseDescriptionMapper;
import com.atcjw.vod.service.CourseDescriptionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {
   @Autowired
   CourseDescriptionMapper courseDescriptionMapper;

    @Override
    public int removeByCourseId(Long id) {
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        return courseDescriptionMapper.delete(wrapper);
    }
}
