package com.chauncey.study.myspringcloud.controller;

import com.chauncey.study.myspringcloud.model.CommonResult;
import com.chauncey.study.myspringcloud.model.Payment;
import com.chauncey.study.myspringcloud.repositories.PaymentRepository;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/2 18:41
 * @Version 1.0
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallBack")
public class PaymentController {

    @Resource
    private PaymentRepository paymentRepository;


    //@HystrixCommand //不指定Property就使用全局降级逻辑
    @HystrixCommand(fallbackMethod = "getPaymentById_error",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
            try {
                TimeUnit.MILLISECONDS.sleep(4000);
            } catch (InterruptedException e) {
                log.error("中断异常",e);
            }
            Payment payment = paymentRepository.findById(id).orElse( null);
        return new CommonResult<Payment>().ofSuccess(payment);
    }

    /**
     * @despretion 全局降级逻辑
     * @author Chauncey
     * @param
     * @return com.chauncey.study.myspringcloud.model.CommonResult<com.chauncey.study.myspringcloud.model.Payment>
     * @throws
     * @date 2020/7/3 17:22
     */
    public CommonResult<Payment> defaultFallBack() {
        return new CommonResult<Payment>().ofFail(null,5000,"服务繁忙，暂时不可用/(ㄒoㄒ)/~~");
    }

    public CommonResult<Payment> getPaymentById_error(@PathVariable("id") Long id) {

        return new CommonResult<Payment>().ofFail(null,5000,"服务繁忙，暂时不可用/(ㄒoㄒ)/~~");
    }


    /**
     * @despretion 断路器
     * @author Chauncey
     * @param id
     * @return com.chauncey.study.myspringcloud.model.CommonResult<com.chauncey.study.myspringcloud.model.Payment>
     * @throws
     * @date 2020/7/8 17:04
     */
    @GetMapping("/payment/circuit/{id}")
    @HystrixCommand(fallbackMethod = "", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true" ),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //窗口内错误次数，超过10次就熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //窗口时间10秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60" ), //错误率，超过60%就熔断
    })
    public CommonResult<Payment> getCircuitPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentRepository.findById(id).orElse( null);
        if (payment == null) {
            throw new RuntimeException("查询不到");
        }
        return new CommonResult<Payment>().ofSuccess(payment);
    }

    public CommonResult<Payment> getCircuitPaymentById_error(@PathVariable("id") Long id) {

        return new CommonResult<Payment>().ofFail(null,5000,"服务繁忙，暂时不可用/(ㄒoㄒ)/~~");
    }

}
