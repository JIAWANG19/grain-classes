package com.atcjw.vod.controller;

import com.atcjw.model.vod.Video;
import com.atcjw.result.RetJson;
import com.atcjw.vod.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/vod/video")
// TODO
@CrossOrigin // 跨域
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/{id}")
    public RetJson get(@PathVariable("id") Long id) {
        Video video = videoService.getById(id);
        return RetJson.ok().put("video", video);
    }

    @PostMapping("")
    public RetJson save(@RequestBody Video video) {
        videoService.save(video);
        return RetJson.ok();
    }

    @PutMapping("")
    public RetJson updateById(@RequestBody Video video) {
        videoService.updateById(video);
        return RetJson.ok();
    }

    @DeleteMapping("/{id}")
    public RetJson remove(@PathVariable Long id) {
        videoService.removeById(id);
        return RetJson.ok();
    }
}
