package com.atcjw.vod.controller;

import com.atcjw.result.RetJson;
import com.atcjw.vod.service.VideoVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("admin/vod/videoVisitor")
public class VideoVisitorController {
    @Autowired
    VideoVisitorService videoVisitorService;

    @GetMapping("/{courseId}/{startDate}/{endDate}")
    public RetJson countCourse(@PathVariable("courseId") Long courseId,
                               @PathVariable("startDate") String startDate,
                               @PathVariable("endDate") String endDate) {
        Map<String, Object> map = videoVisitorService.countCourse(courseId, startDate, endDate);
        return RetJson.ok().setData(map);
    }

}
