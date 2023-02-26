package com.atcjw.vod.controller;

import com.atcjw.model.vod.Course;
import com.atcjw.result.RetJson;
import com.atcjw.vo.vod.CourseFormVo;
import com.atcjw.vo.vod.CourseQueryVo;
import com.atcjw.vod.service.CourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("admin/vod/course")
// TODO
@CrossOrigin // 跨域
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/page/{pageNo}/{pageSize}")
    public RetJson findPage(@PathVariable("pageNo") int pageNo,
                            @PathVariable("pageSize") int pageSize,
                            @RequestBody(required = false) CourseQueryVo courseQueryVo) {
        Page<Course> pageParam = new Page<>(pageNo, pageSize);
        Page<Course> page = courseService.pageQuery(pageParam, courseQueryVo);
        return RetJson.ok().put("page", page);
    }

    @PostMapping("")
    public RetJson insert(@RequestBody CourseFormVo courseFormVo) {
        Long courseId = courseService.saveCourseInfo(courseFormVo);
        return RetJson.ok().put("id", courseId);
    }

    @GetMapping("/{id}")
    public RetJson getById(@PathVariable("id") long id) {
        CourseFormVo course = courseService.getInfoById(id);
        return RetJson.ok().put("course", course);
    }

    @PutMapping("")
    public RetJson update(@RequestBody CourseFormVo course) {
        boolean success = courseService.updateCourseInfo(course);
        return RetJson.ok();
    }
}
