package com.atcjw.vod.dao;

import com.atcjw.model.vod.Course;
import com.atcjw.vo.vod.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    CoursePublishVo selectPublishVoById(Long id);
}
