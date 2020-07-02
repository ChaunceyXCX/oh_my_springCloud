package com.chauncey.study.myspringcloud.controller;

import com.chauncey.study.myspringcloud.lb.MyLoadBalancer;
import com.chauncey.study.myspringcloud.model.CommonResult;
import com.chauncey.study.myspringcloud.model.Payment;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/5/23 18:44
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/consumer")
@Api(value = "消费接口",tags = "消费接口80")
public class ConsumerController {

    // private static String bathUrl = "http://127.0.0.1:8001";
    private static String bathUrl = "http://CLOUD-PROVIDER-PAYMENT";
    private static String getPayMent = "/payment/get/";
    private static String creatPayment = "/payment/create";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private MyLoadBalancer myLoadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


    /**
     * @despretion robin规则
     * @author Chauncey
     * @param id
     * @return com.chauncey.study.myspringcloud.model.CommonResult<com.chauncey.study.myspringcloud.model.Payment>
     * @throws
     * @date 2020/7/1 18:04
     */
    @GetMapping("/get/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        return restTemplate.getForEntity(bathUrl+getPayMent+id,CommonResult.class).getBody();
    }


    @PostMapping("create/payment")
    public CommonResult<Payment> crreatePayment(@RequestBody Payment payment){

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if(serviceInstanceList == null && serviceInstanceList.size() <=0) {
            return null;
        }

        //return restTemplate.postForEntity(bathUrl+creatPayment,payment,CommonResult.class).getBody();
        return restTemplate.postForEntity(myLoadBalancer.instance(serviceInstanceList).getUri()+creatPayment,payment,CommonResult.class).getBody();
    }


}
