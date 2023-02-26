package com.atcjw.vod.service.impl;

import com.atcjw.model.vod.Chapter;
import com.atcjw.vod.dao.ChapterMapper;
import com.atcjw.vod.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
}
