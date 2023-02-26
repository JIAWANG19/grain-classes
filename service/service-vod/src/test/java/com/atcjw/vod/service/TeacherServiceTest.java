package com.atcjw.vod.service;

import com.atcjw.model.vod.Teacher;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceTest implements ServiceBaseTest {
    @Autowired
    TeacherService teacherService;

    @Test
    public void testPage() {
        Page<Teacher> page = new Page<>(1,2);
        Page<Teacher> pageInfo = teacherService.page(page);
        pageInfo.getRecords().forEach(System.out::println);
    }
}
