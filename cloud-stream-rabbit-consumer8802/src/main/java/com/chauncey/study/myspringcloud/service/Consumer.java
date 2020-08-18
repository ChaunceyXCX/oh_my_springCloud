package com.chauncey.study.myspringcloud.service;

import com.chauncey.study.myspringcloud.binders.CustomBinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/26 18:21
 * @Version 1.0
 **/
@EnableBinding(CustomBinder.class)
@Slf4j
public class Consumer {

    @Autowired
    private MessageChannel myOutput1;

    @Autowired
    private MessageChannel myOutput2;


    @StreamListener("myInput")
    public void receive(Message<String> messages) {
        log.info("收到消息：8802:{}",messages.getPayload());
        myOutput1.send(messages);
        log.info("发送消息1：{}",messages.getPayload());
        myOutput2.send(messages);
        log.info("发送消息2：{}",messages.getPayload());
    }
}
