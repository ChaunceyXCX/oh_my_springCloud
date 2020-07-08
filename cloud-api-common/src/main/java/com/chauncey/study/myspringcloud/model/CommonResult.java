package com.chauncey.study.myspringcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResult
 * @Author Chauncey
 * @Date 2020/5/17 15:47
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult<T> ofSuccess(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
        return this;
    }

    public CommonResult<T> ofSuccess(T data,String message) {
        this.code = 200;
        this.message = message;
        this.data = data;
        return this;
    }

    public CommonResult<T> ofFail(T data,Integer code,String message) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public CommonResult(T data) {
        this.data = data;
    }

    public CommonResult() {
    }
}
