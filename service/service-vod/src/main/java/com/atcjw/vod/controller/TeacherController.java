package com.atcjw.vod.controller;

import com.atcjw.model.vod.Teacher;
import com.atcjw.utils.RetJson;
import com.atcjw.vo.vod.TeacherQueryVo;
import com.atcjw.vod.dao.TeacherDao;
import com.atcjw.vod.service.TeacherService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("vod/teacher")
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/list")
    public RetJson queryAllTeacher() {
        List<Teacher> list = teacherService.queryAllTeacher();
        return RetJson.ok().put("list", list);
    }

    @DeleteMapping("/{id}")
    public RetJson deleteTeacher(@PathVariable("id") long id) {
        int message = teacherService.deleteTeacher(id);
        if (message == 1) return RetJson.ok();
        else return RetJson.fail("删除失败");
    }

    @PostMapping("findQueryPage/{pageNo}/{pageSize}")
    public RetJson findPage(@PathVariable("pageNo") int pageNo,
                            @PathVariable("pageSize") int pageSize,
                            @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        PageInfo<Teacher> pageInfo = teacherService.page(pageNo, pageSize, teacherQueryVo);
        return RetJson.ok().put("pageInfo", pageInfo);
    }

    @PostMapping("/")
    public RetJson insertTeacher(@RequestBody Teacher teacher) {
        int message = teacherService.insertTeacher(teacher);
        if (message == 1) return RetJson.ok();
        else return RetJson.fail("添加失败");
    }

    @GetMapping("/{id}")
    public RetJson getTeacherById(@PathVariable("id") long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return RetJson.ok().put("teacher", teacher);
    }

    @PutMapping("/{id}")
    public RetJson updateTeacher(@PathVariable("id") long id,
                                 @RequestBody Teacher teacher) {
        int isSuccess = teacherService.updateTeacher(id, teacher);
        if (isSuccess == 1) return RetJson.ok();
        else return RetJson.fail("修改失败");
    }

    @DeleteMapping("/")
    public RetJson deleteTeacherList(@RequestBody List<Long> ids) {
        int message = teacherService.deleteTeacherList(ids);
        if (message == ids.size()) return RetJson.ok();
        else return RetJson.fail("批量删除失败");
    }
}
