package com.chauncey.study.myspringcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/26 18:21
 * @Version 1.0
 **/
@EnableBinding(Sink.class)
@Slf4j
public class Consumer {

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        log.info(message.getPayload());
    }
}
