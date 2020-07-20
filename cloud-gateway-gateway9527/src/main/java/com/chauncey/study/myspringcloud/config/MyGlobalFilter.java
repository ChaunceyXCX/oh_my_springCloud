package com.chauncey.study.myspringcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @ClassName MyGlobalFilter
 * @Description TODO
 * @Author Chauncey
 * @Date 2020/7/16 17:48
 * @Version 1.0
 **/
@Configuration
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    /**
     * @despretion 自定义过滤器实现
     * @author Chauncey
     * @param exchange
     * @param chain
     * @return reactor.core.publisher.Mono<java.lang.Void>
     * @throws
     * @date 2020/7/16 17:51
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("global filter: {}", new Date());
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        if (!serverHttpRequest.getHeaders().containsKey("userName")){
            log.info("没有请求头");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    /**
     * @despretion filter加载顺序越小优先级越高
     * @author Chauncey
     * @param
     * @return int
     * @throws
     * @date 2020/7/16 17:50
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
