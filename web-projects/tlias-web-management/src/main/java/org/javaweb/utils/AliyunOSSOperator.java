package org.javaweb.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.*;
import org.javaweb.pojo.AliyunOSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class AliyunOSSOperator {

    @Value("${aliyun.oss.access-key-id}")
    private String accessKeyId;
    @Value("${aliyun.oss.access-key-secret}")
    private String accessKeySecret;

    @Autowired
    private AliyunOSSProperties aliyunOSSProperties;

    public String upload(byte[] content, String originalFilename) throws Exception {
        // 从环境变量中获取访问凭证（注：你配置了access-key，这里也可以直接用固定凭证，二选一即可）
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 日期目录规则（保留你的原有逻辑）
        String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));

        // 安全截取后缀（之前的修复保留，兼容无后缀文件）
        String suffix = originalFilename.contains(".") ? originalFilename.substring(originalFilename.lastIndexOf(".")) : "";
        String newFileName = UUID.randomUUID() + suffix;
        String objectName = dir + "/" + newFileName;

        // 创建OSSClient实例（保留你的原有配置）
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(aliyunOSSProperties.getEndpoint())
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(aliyunOSSProperties.getRegion())
                .build();

        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(aliyunOSSProperties.getBucketName(), objectName, new ByteArrayInputStream(content));
            ossClient.putObject(putObjectRequest);
        } finally {
            ossClient.shutdown();
        }

        // ========== 核心修复：正确拼接OSS文件访问URL（第54行） ==========
        // 原错误：endpoint无//，split后数组长度1，取[1]越界
        // 修复后：直接拼接Bucket域名+endpoint+文件路径（OSS标准访问格式）
        return "https://" + aliyunOSSProperties.getBucketName() + "." + aliyunOSSProperties.getEndpoint() + "/" + objectName;
    }
}