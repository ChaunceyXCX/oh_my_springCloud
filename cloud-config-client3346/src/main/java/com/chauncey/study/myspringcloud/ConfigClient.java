package com.chauncey.study.myspringcloud;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName ConfigClient
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/24 14:50
 * @Version 1.0
 **/
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
@EnableEurekaClient
public class ConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class,args);
    }
}
