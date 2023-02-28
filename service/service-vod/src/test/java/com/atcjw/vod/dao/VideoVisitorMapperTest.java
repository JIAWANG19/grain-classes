package com.atcjw.vod.dao;

import com.atcjw.model.vod.VideoVisitor;
import com.atcjw.vo.vod.VideoVisitorCountVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VideoVisitorMapperTest implements MapperBaseTest {
    @Autowired
    VideoVisitorMapper videoVisitorMapper;

    @Test
    public void testSelectList() {
        List<VideoVisitor> videoVisitors = videoVisitorMapper.selectList(null);
        videoVisitors.forEach(System.out::println);
    }

    @Test
    public void testCountCourse() {
        List<VideoVisitorCountVo> list = videoVisitorMapper.countCourse(19L, "2021-01-01", "2022-12-12");
        list.forEach(System.out::println);
    }
}
