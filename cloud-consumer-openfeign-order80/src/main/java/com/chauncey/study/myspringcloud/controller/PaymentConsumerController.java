package com.chauncey.study.myspringcloud.controller;

import com.chauncey.study.myspringcloud.model.CommonResult;
import com.chauncey.study.myspringcloud.model.Payment;
import com.chauncey.study.myspringcloud.service.PaymentConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentConsumerController
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/2 11:20
 * @Version 1.0
 **/
@RestController
@RequestMapping("/comsumer")
public class PaymentConsumerController {

    @Resource
    private PaymentConsumerService paymentConsumerService;

    //@HystrixCommand(fallbackMethod = "getPaymentById_error", //降级需要执行的方法
    //        commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")  //指定需要降级的场景：请求时间超过两秒即降级
    //})
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentConsumerService.getPaymentById(id);
    }


    public CommonResult<Payment> getPaymentById_error(@PathVariable("id") Long id) {
        return new CommonResult<Payment>().ofFail(null,5000,"服务繁忙，暂时不可用/(ㄒoㄒ)/~~");
    }
}
