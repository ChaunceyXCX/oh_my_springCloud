package com.chauncey.study.myspringcloud.controller;

import com.chauncey.study.myspringcloud.model.CommonResult;
import com.chauncey.study.myspringcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MessageProviderController
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/26 17:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/provider")
public class MessageProviderController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/get/simplesend")
    public CommonResult<String> messageProvider() {
        new Thread(() -> {
            int i = 1;
            while (i<4000){
                messageProvider.send(i);
                i++;
            }
        }).start();
        return new CommonResult<String>().ofSuccess("ok");
    }
}
