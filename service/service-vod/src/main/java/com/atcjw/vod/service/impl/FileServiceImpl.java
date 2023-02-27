package com.atcjw.vod.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.atcjw.vod.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
//@PropertySource("classpath:aliyunOOS.properties")
@CrossOrigin
public class FileServiceImpl implements FileService {

//    @NacosValue("${alibaba.oos.file.endpoint}")
//    private String endpoint;
//
//    @NacosValue("${alibaba.oss.file.keyId}")
//    private String keyId;
//
//    @NacosValue("${alibaba.oos.file.keySecret}")
//    private String keySecret;
//
//    @NacosValue("${alibaba.oos.file.bucketName}")
//    private String bucketName;


    @Value("${alibaba.oos.file.endpoint}")
    private String endpoint;

    @Value("${alibaba.oss.file.keyId}")
    private String keyId;

    @Value("${alibaba.oos.file.keySecret}")
    private String keySecret;

    @Value("${alibaba.oos.file.bucketName}")
    private String bucketName;

    /**
     * 文件上传
     * @return 文件路径
     */
    @Override
    public String upload(MultipartFile file) {
        OSS ossClient = new OSSClientBuilder().build("https://" + endpoint, keyId, keySecret);
        String key = UUID.randomUUID().toString().replaceAll("-", "") +
                Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = new DateTime().toString("yyyy/MM/dd") + "/" + key;

        try {
            InputStream inputStream = file.getInputStream();
            ObjectMetadata objectMetadata = new ObjectMetadata();
            PutObjectRequest putObjectRequest =
                    new PutObjectRequest(bucketName, fileName, inputStream, objectMetadata);
            // 设置公开读
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setObjectAcl(CannedAccessControlList.PublicRead);
            putObjectRequest.setMetadata(metadata);
            putObjectRequest.setProcess("true");
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            log.info("文件上传成功, url: {}", url);
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("文件上传失败");
            return null;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
