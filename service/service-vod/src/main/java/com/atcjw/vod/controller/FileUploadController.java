package com.atcjw.vod.controller;

import com.atcjw.result.RetJson;
import com.atcjw.vod.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin/vod/file")
public class FileUploadController {
    @Autowired
    FileService fileService;


    @PostMapping("")
    public RetJson uploadFile(MultipartFile file) {
        String url = fileService.upload(file);
        return RetJson.ok().put("url", url);
    }

}
