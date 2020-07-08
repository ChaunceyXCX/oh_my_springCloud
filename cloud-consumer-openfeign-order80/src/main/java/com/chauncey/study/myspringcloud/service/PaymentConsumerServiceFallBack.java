package com.chauncey.study.myspringcloud.service;

import com.chauncey.study.myspringcloud.model.CommonResult;
import com.chauncey.study.myspringcloud.model.Payment;
import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentConsumerServiceFallBack
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/3 17:25
 * @Version 1.0
 **/
@Component
public class PaymentConsumerServiceFallBack implements PaymentConsumerService {

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return new CommonResult<Payment>().ofFail(null,5000,"PaymentConsumerServiceFallBack,服务繁忙，暂时不可用/(ㄒoㄒ)/~~");
    }
}
