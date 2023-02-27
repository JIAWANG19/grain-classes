package com.atcjw.vod.controller;

import com.atcjw.model.vod.Subject;
import com.atcjw.result.RetJson;
import com.atcjw.vod.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/vod/subject")
// TODO
//@CrossOrigin // 跨域
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/byParentId/{parentId}")
    public RetJson getByParentId(@PathVariable("parentId") int parentId) {
        List<Subject> subjects = subjectService.getByParentId(parentId);
        // todo
        return RetJson.ok().put("list", subjects);
    }

}
