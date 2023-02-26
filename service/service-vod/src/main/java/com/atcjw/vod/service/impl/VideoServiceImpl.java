package com.atcjw.vod.service.impl;

import com.atcjw.model.vod.Video;
import com.atcjw.vod.dao.VideoMapper;
import com.atcjw.vod.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
}
