package com.atcjw.order.service;

import com.atcjw.model.vod.VideoVisitor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface VideoVisitorService extends IService<VideoVisitor> {
    Map<String, Object> countCourse(Long courseId, String startDate, String endDate);
}
