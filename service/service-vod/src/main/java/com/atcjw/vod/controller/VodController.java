package com.atcjw.vod.controller;

import com.atcjw.result.RetJson;
import com.atcjw.vod.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/vod")
// todo
//@CrossOrigin // 跨域
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
