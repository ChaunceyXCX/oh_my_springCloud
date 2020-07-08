package com.chauncey.study.myspringcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName FeignClientConfig
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/2 14:39
 * @Version 1.0
 **/
@Configuration
public class FeignClientConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
