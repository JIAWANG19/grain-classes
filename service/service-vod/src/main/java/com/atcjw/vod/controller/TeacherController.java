package com.atcjw.vod.controller;

import com.atcjw.model.vod.Teacher;
import com.atcjw.utils.R;
import com.atcjw.vod.service.TeacherService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("vod/teacher")
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/list")
    public R queryAllTeacher() {
        List<Teacher> list = teacherService.queryAllTeacher();
        return R.ok().put("list", list);
    }

//    @PutMapping("/")
//    public R addTeacher(@RequestBody Teacher) {
//
//    }

    @DeleteMapping("/{id}")
    public R deleteTeacher(@PathVariable long id) {
        int message = teacherService.deleteTeacher(id);
        return R.ok().put("message", message);
    }
}
