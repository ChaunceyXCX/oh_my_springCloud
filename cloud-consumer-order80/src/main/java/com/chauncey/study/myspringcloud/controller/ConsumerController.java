package com.chauncey.study.myspringcloud.controller;

import com.chauncey.study.myspringcloud.model.CommonResult;
import com.chauncey.study.myspringcloud.model.Payment;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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


    @GetMapping("/get/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {

        return restTemplate.getForEntity(bathUrl+getPayMent+id,CommonResult.class).getBody();
    }

    @PostMapping("create/payment")
    public CommonResult<Payment> crreatePayment(@RequestBody Payment payment){

        return restTemplate.postForEntity(bathUrl+creatPayment,payment,CommonResult.class).getBody();
    }
}
