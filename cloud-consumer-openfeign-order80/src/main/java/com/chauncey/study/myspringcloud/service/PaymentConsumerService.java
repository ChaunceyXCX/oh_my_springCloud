package com.chauncey.study.myspringcloud.service;

import com.chauncey.study.myspringcloud.model.CommonResult;
import com.chauncey.study.myspringcloud.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentConsumerService
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/2 11:17
 * @Version 1.0
 **/
@Service
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT",//指定服务域
        fallback = PaymentConsumerServiceFallBack.class ) //指定FallBack类
public interface PaymentConsumerService {

    @GetMapping("/payment/get/{id}")  //指定服务URL
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
