package com.aliyun.oss;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OSS自动配置类（注入配置属性类到操作类）
 */
@Configuration
@ConditionalOnClass(OSS.class) // 有OSS依赖才生效
@EnableConfigurationProperties(AliyunOSSProperties.class) // 启用配置属性绑定
public class AliyunOSSAutoconfiguration {

    /**
     * 注册OSS操作类，注入配置属性类
     */
    @Bean
    @ConditionalOnMissingBean // 允许用户自定义覆盖
    public AliyunOSSOperator aliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties) {
        // 构造器注入配置属性类
        return new AliyunOSSOperator(aliyunOSSProperties);
    }
}