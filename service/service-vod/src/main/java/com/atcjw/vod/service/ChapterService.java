package com.atcjw.vod.service;

import com.atcjw.model.vod.Chapter;
import com.atcjw.vo.vod.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ChapterService extends IService<Chapter> {
    List<ChapterVo> getTreeList(Long courseId);

    int removeByCourseId(Long id);
}
