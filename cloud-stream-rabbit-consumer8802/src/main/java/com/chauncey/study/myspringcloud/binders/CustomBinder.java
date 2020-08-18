package com.chauncey.study.myspringcloud.binders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ClassName CustomBinder
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/8/6 17:13
 * @Version 1.0
 **/
public interface CustomBinder {

    @Output("myOutput1")
    MessageChannel myOutput1();

    @Output("myOutput2")
    MessageChannel myOutput2();

    @Input("myInput")
    SubscribableChannel input();
}
