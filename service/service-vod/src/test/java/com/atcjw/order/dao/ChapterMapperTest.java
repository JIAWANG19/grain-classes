package com.atcjw.order.dao;

import com.atcjw.model.vod.Chapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class ChapterMapperTest implements MapperBaseTest{
    @Autowired
    ChapterMapper chapterMapper;

    @Test
    public void testSelectList() {
        List<Chapter> chapters = chapterMapper.selectList(null);
        chapters.forEach(System.out::println);
    }
}