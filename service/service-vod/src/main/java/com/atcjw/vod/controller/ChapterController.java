package com.atcjw.vod.controller;

import com.atcjw.model.vod.Chapter;
import com.atcjw.result.RetJson;
import com.atcjw.vo.vod.ChapterVo;
import com.atcjw.vod.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/vod/chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    /**
     * 根据 courseId 查询章节和小节
     *
     * @param courseId 课程id
     * @return ChapterVo
     */
    @GetMapping("/treeList/{courseId}")
    public RetJson getTreeList(@PathVariable("courseId") Long courseId) {
        List<ChapterVo> chapterList = chapterService.getTreeList(courseId);
        return RetJson.ok().put("treeList", chapterList);
    }

    /**
     * 添加章节
     */
    @PostMapping("")
    public RetJson insert(@RequestBody Chapter chapter) {
        chapterService.save(chapter);
        return RetJson.ok();
    }

    /**
     * 根据 id 获取章节
     * @param id 章节id
     */
    @GetMapping("/{id}")
    public RetJson getById(@PathVariable("id") Long id) {
        Chapter chapter = chapterService.getById(id);
        return RetJson.ok().put("chapter", chapter);
    }

    /**
     * 修改章节
     */
    @PutMapping("")
    public RetJson update(@RequestBody Chapter chapter) {
        chapterService.updateById(chapter);
        return RetJson.ok();
    }

    /**
     * 根据 id 删除章节
     * @param id 章节id
     */
    @DeleteMapping("/{id}")
    public RetJson deleteById(@PathVariable("id") Long id) {
        chapterService.removeById(id);
        return RetJson.ok();
    }

}
