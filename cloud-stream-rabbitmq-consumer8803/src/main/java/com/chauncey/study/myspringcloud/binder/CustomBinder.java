package com.chauncey.study.myspringcloud.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ClassName CustomBinder
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/8/6 17:24
 * @Version 1.0
 **/
public interface CustomBinder {

    @Input("myInput1")
    SubscribableChannel myInput1();

    @Input("myInput2")
    SubscribableChannel myInput2();
}
