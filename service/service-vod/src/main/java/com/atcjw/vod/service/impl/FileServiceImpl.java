package com.atcjw.vod.service.impl;

import com.atcjw.vod.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file) {
        // TODO 头像上传功能
        return null;
    }
}
