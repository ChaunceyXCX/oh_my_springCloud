package com.chauncey.study.myspringcloud.service.impl;

import cn.hutool.Hutool;
import cn.hutool.core.util.IdUtil;
import com.chauncey.study.myspringcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @ClassName MessageProviderImpl
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/26 16:15
 * @Version 1.0
 **/
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send(int i) {

        String uuid = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(i+"=====>>>"+uuid).build());
        log.info(i+"=====>>>"+uuid);
        return uuid;
    }
}
