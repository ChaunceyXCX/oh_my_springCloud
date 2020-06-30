package com.chauncey.study.myspringcloud.controller;

import com.chauncey.study.myspringcloud.model.ValidList;
import com.chauncey.study.myspringcloud.model.Payment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName ValidTestConroller
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/6/26 11:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/valid")
@ResponseBody
public class ValidTestController {

    @PostMapping("/test")
    public String ValidTest(@Valid @RequestBody Payment payment) {

        return "success";
    }
}
