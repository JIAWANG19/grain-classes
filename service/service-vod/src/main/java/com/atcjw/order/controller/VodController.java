package com.atcjw.order.controller;

import com.atcjw.result.RetJson;
import com.atcjw.order.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/vod")
public class VodController {
    @Autowired
    VodService vodService;

    /**
     * 上传视频
     */
    @PostMapping("")
    public RetJson upload() {
        return RetJson.ok();
    }
}
