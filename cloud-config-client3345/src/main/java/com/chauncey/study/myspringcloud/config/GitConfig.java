package com.chauncey.study.myspringcloud.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName GitConfig
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/24 15:20
 * @Version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "data")
public class GitConfig {
    private String profile;
}
