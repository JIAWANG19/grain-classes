package com.atcjw.vod.controller;

import com.atcjw.model.vod.Teacher;
import com.atcjw.result.RetJson;
import com.atcjw.vo.vod.TeacherQueryVo;
import com.atcjw.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admin/vod/teacher")
@RestController
// TODO
@CrossOrigin // 跨域
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/list")
    public RetJson queryAllTeacher() {
        List<Teacher> list = teacherService.list();
        return RetJson.ok().put("list", list);
    }

    @DeleteMapping("/{id}")
    public RetJson deleteTeacher(@PathVariable("id") long id) {
        boolean message = teacherService.removeById(id);
        if (message) return RetJson.ok();
        else return RetJson.fail("删除失败");
    }

    @PostMapping("/page/{pageNo}/{pageSize}")
    public RetJson findPage(@PathVariable("pageNo") int pageNo,
                            @PathVariable("pageSize") int pageSize,
                            @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
        QueryWrapper<Teacher> wrapper = null;
        if (teacherQueryVo != null) {
            wrapper = new QueryWrapper<>();
            String name = teacherQueryVo.getName();
            Integer level = teacherQueryVo.getLevel();
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();
            if (StringUtils.hasLength(name)) {
                wrapper.like("name", name);
            }
            if (level != null) {
                wrapper.eq("level", level);
            }
            if (StringUtils.hasLength(joinDateBegin)) {
                wrapper.ge("join_date", joinDateBegin);
            }
            if (StringUtils.hasLength(joinDateEnd)) {
                wrapper.le("join_date", joinDateEnd);
            }
        }
        Page<Teacher> page = new Page<>(pageNo, pageSize);
        Page<Teacher> pageInfo = teacherService.page(page, wrapper);
        return RetJson.ok().put("pageInfo", pageInfo);
    }

    @PostMapping("")
    public RetJson insertTeacher(@RequestBody Teacher teacher) {
        boolean message = teacherService.save(teacher);
        if (message) return RetJson.ok();
        else return RetJson.fail("添加失败");
    }

    @GetMapping("/{id}")
    public RetJson getTeacherById(@PathVariable("id") long id) {
        Teacher teacher = teacherService.getById(id);
        return RetJson.ok().put("teacher", teacher);
    }

    @PutMapping("")
    public RetJson updateTeacher(@RequestBody Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);
        if (isSuccess) return RetJson.ok();
        else return RetJson.fail("修改失败");
    }

    @DeleteMapping("")
    public RetJson deleteTeacherList(@RequestBody List<Long> ids) {
        boolean message = teacherService.removeByIds(ids);
        if (message) return RetJson.ok();
        else return RetJson.fail("批量删除失败");
    }
}
