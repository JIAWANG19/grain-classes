package com.atcjw.order.service;

import com.atcjw.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

public interface VideoService extends IService<Video> {
    int removeByCourseId(Long id);
}
