package com.chauncey.study.myspringcloud.controller;

import com.chauncey.study.myspringcloud.config.GitConfig;
import com.chauncey.study.myspringcloud.model.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigTest
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/24 15:01
 * @Version 1.0
 **/
@RestController
@RequestMapping("/config/test")
@Slf4j
@RefreshScope //开启配置文件刷新
public class ConfigTest {

    @Autowired
    private GitConfig gitConfig;

    @Value("${data.profile}")
    private String profile;

    @GetMapping("/get/profile")
    public CommonResult<String> getProfile() {
        log.info(gitConfig.getProfile());
        log.info(profile);
        return new CommonResult<String>().ofSuccess(profile);
    }
}
