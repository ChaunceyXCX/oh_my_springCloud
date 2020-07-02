package com.chauncey.study.myspringcloud.lb;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyRondRule
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/1 18:22
 * @Version 1.0
 **/
@Slf4j
@Component
public class MyRondRule implements  MyLoadBalancer {

    private AtomicInteger serverIndex = new AtomicInteger(0);

    public final int getAndIncreaseMent() {
        int current;
        int next ;
        do {
            current = this.serverIndex.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        }while (!serverIndex.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        int next = getAndIncreaseMent();
        log.info("当前第：{}次访问",next);
        int index = next%serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }


}
