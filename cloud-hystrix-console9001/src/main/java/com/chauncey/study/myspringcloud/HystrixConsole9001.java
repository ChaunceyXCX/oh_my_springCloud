package com.chauncey.study.myspringcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName HystrixConsole9001
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/8 17:32
 * @Version 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard  //开启Hystrixkongzhitai
public class HystrixConsole9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixConsole9001.class,args);
    }
}
