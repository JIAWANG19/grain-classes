package com.atcjw.vod.service.impl;

import com.atcjw.model.vod.CourseDescription;
import com.atcjw.vod.dao.CourseDescriptionMapper;
import com.atcjw.vod.service.CourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {
}
