package com.chauncey.study.myspringcloud.service;

import com.chauncey.study.myspringcloud.binder.CustomBinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @ClassName MyCustomer
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/8/11 17:58
 * @Version 1.0
 **/
@EnableBinding(CustomBinder.class)
@Slf4j
public class MyCustomer {

    @StreamListener("myInput1")
    void Listen1(Message<String> message) {
        log.info("接收1：{}",message.getPayload());
    }


    @StreamListener("myInput2")
    void Listen2(Message<String> message) {
        log.info("接收2：{}",message.getPayload());
    }

}
