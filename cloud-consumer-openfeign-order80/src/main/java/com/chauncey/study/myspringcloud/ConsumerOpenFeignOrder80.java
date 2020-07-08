package com.chauncey.study.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ConsumerOpenFeignOrder80Application
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/2 11:14
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients //启用OpenFeign
@EnableHystrix //启用Hystrix
@EnableCircuitBreaker
public class ConsumerOpenFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeignOrder80.class,args);
    }
}
