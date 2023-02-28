package com.atcjw.vod.dao;


import com.atcjw.model.vod.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubjectMapperTest implements MapperBaseTest {
    @Autowired
    SubjectMapper subjectMapper;

    @Test
    public void testSelectList() {
        List<Subject> subjects = subjectMapper.selectList(null);
        subjects.forEach(System.out::println);
    }
}
