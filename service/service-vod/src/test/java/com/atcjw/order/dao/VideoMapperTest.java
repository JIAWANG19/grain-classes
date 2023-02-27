package com.atcjw.order.dao;

import com.atcjw.model.vod.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VideoMapperTest implements MapperBaseTest {
    @Autowired
    VideoMapper videoMapper;

    @Test
    public void testSelectList() {
        List<Video> videos = videoMapper.selectList(null);
        videos.forEach(System.out::println);
    }
}
