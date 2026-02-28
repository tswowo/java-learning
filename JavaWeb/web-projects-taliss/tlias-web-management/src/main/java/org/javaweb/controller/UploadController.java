package org.javaweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.javaweb.pojo.Result;
import org.javaweb.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件{}上传开始...", file.getOriginalFilename());
        //交给OSS存储
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件{}上传OSS成功，访问地址为：{}", file.getOriginalFilename(), url);
        return Result.success(url);
    }
}