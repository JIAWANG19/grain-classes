package com.atcjw.order.service;

import com.atcjw.model.vod.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubjectServiceTest implements ServiceBaseTest {
    @Autowired
    SubjectService subjectService;

    @Test
    public void TestGetByParentId() {
        List<Subject> subjects = subjectService.getByParentId(0);
        subjects.forEach(System.out::println);
    }
}
