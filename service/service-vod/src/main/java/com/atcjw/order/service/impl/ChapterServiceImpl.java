package com.atcjw.order.service.impl;

import com.atcjw.model.vod.Chapter;
import com.atcjw.model.vod.Video;
import com.atcjw.vo.vod.ChapterVo;
import com.atcjw.vo.vod.VideoVo;
import com.atcjw.order.dao.ChapterMapper;
import com.atcjw.order.service.ChapterService;
import com.atcjw.order.service.VideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    VideoService videoService;


    @Override
    public List<ChapterVo> getTreeList(Long courseId) {
        List<ChapterVo> result = new ArrayList<>();

        // 根据 courseId 查询所有章节
        QueryWrapper<Chapter> wrapperChapter = new QueryWrapper<>();
        wrapperChapter.eq("course_id", courseId);
        List<Chapter> chapterList = chapterMapper.selectList(wrapperChapter);

        // 根据 courseId 查询所有小节
        QueryWrapper<Video> wrapperVideo = new QueryWrapper<>();
        wrapperVideo.eq("course_id", courseId);
        List<Video> videoList = videoService.list(wrapperVideo);

        chapterList.forEach(chapter -> {
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVo.setChildren(new ArrayList<>());
            videoList.stream().filter(video -> Objects.equals(chapter.getId(), video.getChapterId())).forEach(e -> {
                VideoVo videoVo = new VideoVo();
                BeanUtils.copyProperties(e, videoVo);
                chapterVo.getChildren().add(videoVo);
            });
            result.add(chapterVo);
        });

        return result;
    }

    @Override
    public int removeByCourseId(Long id) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        return chapterMapper.delete(wrapper);
    }
}
