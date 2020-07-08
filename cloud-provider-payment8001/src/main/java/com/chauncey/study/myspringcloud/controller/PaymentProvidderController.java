package com.chauncey.study.myspringcloud.controller;

import com.chauncey.study.myspringcloud.model.CommonResult;
import com.chauncey.study.myspringcloud.model.Payment;
import com.chauncey.study.myspringcloud.repositories.PaymentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentProvidderController
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/5/17 22:18
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
@Api(value = "支付消费方",tags="8001")
public class PaymentProvidderController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @ApiOperation(value = "获取信息",notes = "通过ID获取Payment")
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        try {
            TimeUnit.SECONDS.sleep(10);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return new CommonResult<Payment>().ofSuccess(paymentRepository.getOne(id),serverPort);
    }

    @PostMapping("/create")
    public CommonResult<Payment> createOne(@RequestBody Payment payment) {
        return new CommonResult<Payment>().ofSuccess(paymentRepository.save(payment),serverPort);
    }

    @GetMapping("/discovery")
    public CommonResult<List<String>> getDiscovery() {
        List<String> services = discoveryClient.getServices();

        return new CommonResult<List<String>>()
                .ofSuccess(services);
    }

    @GetMapping
    public CommonResult<String> getService() {
        return new CommonResult<String>()
                .ofSuccess(serverPort);
    }
}
