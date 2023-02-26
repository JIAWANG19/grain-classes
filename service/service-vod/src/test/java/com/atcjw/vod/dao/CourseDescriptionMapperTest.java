package com.atcjw.vod.dao;

import com.atcjw.model.vod.CourseDescription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseDescriptionMapperTest implements MapperBaseTest{
    @Autowired
    CourseDescriptionMapper courseDescriptionMapper;

    @Test
    public void testSelectList() {
        List<CourseDescription> courseDescriptions = courseDescriptionMapper.selectList(null);
        courseDescriptions.forEach(System.out::println);
    }
}
