package com.chauncey.study.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @ClassName HystrixProviderPayment8001
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/2 18:39
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class HystrixProviderPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixProviderPayment8001.class,args);
    }
}
