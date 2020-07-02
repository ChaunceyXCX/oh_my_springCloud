package com.chauncey.study.myspringcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MyLoadBalancer
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/1 18:19
 * @Version 1.0
 **/
public interface MyLoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
