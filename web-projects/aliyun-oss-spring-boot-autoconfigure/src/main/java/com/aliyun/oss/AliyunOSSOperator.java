package com.aliyun.oss;

import com.aliyun.oss.AliyunOSSProperties;
import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.*;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * 阿里云OSS核心操作类（移除@Component，通过构造器注入配置）
 */
public class AliyunOSSOperator {

    // 配置属性类（统一管理所有配置）
    private final AliyunOSSProperties aliyunOSSProperties;

    // 构造器注入（替代@Autowired）
    public AliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties) {
        this.aliyunOSSProperties = aliyunOSSProperties;
    }

    public String upload(byte[] content, String originalFilename) throws Exception {
        // 1. 获取AK/SK（从配置属性类中取，替代@Value）
        String accessKeyId = aliyunOSSProperties.getAccessKeyId();
        String accessKeySecret = aliyunOSSProperties.getAccessKeySecret();

        // 2. 可选：优先使用配置文件的AK/SK，没有则用环境变量（增强兼容性）
        CredentialsProvider credentialsProvider;
        if (accessKeyId != null && !accessKeyId.isEmpty()
                && accessKeySecret != null && !accessKeySecret.isEmpty()) {
            // 使用配置文件的AK/SK
            credentialsProvider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
        } else {
            // 降级使用环境变量
            credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        }

        // 3. 构建文件路径（原有逻辑不变）
        String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
        String suffix = originalFilename.contains(".") ? originalFilename.substring(originalFilename.lastIndexOf(".")) : "";
        String newFileName = UUID.randomUUID() + suffix;
        String objectName = dir + "/" + newFileName;

        // 4. 创建OSS客户端（原有逻辑不变）
        ClientBuilderConfiguration clientConfig = new ClientBuilderConfiguration();
        clientConfig.setSignatureVersion(SignVersion.V4);
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(aliyunOSSProperties.getEndpoint())
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientConfig)
                .region(aliyunOSSProperties.getRegion())
                .build();

        try {
            // 5. 执行上传
            PutObjectRequest putRequest = new PutObjectRequest(
                    aliyunOSSProperties.getBucketName(),
                    objectName,
                    new ByteArrayInputStream(content)
            );
            ossClient.putObject(putRequest);

            // 6. 拼接访问URL
            return "https://" + aliyunOSSProperties.getBucketName() + "." + aliyunOSSProperties.getEndpoint() + "/" + objectName;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}