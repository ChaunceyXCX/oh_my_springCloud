package com.chauncey.study.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @ClassName ZipkinServer6001
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/8/11 18:31
 * @Version 1.0
 **/
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServer6001 {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServer6001.class,args);
    }
}
