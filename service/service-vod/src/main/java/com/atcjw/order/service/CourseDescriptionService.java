package com.atcjw.order.service;

import com.atcjw.model.vod.CourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CourseDescriptionService extends IService<CourseDescription> {
    int removeByCourseId(Long id);
}
