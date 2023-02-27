package com.atcjw.order.service.impl;

import com.atcjw.model.vod.Video;
import com.atcjw.order.dao.VideoMapper;
import com.atcjw.order.service.VideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
    @Autowired
    VideoMapper videoMapper;

    @Override
    public int removeByCourseId(Long id) {
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        return videoMapper.delete(wrapper);
    }
}
