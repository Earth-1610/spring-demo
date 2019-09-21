package com.itangcent.springbootwebfluxdemo.controller;


import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;


/**
 * Entity相关
 */
@RestController
@RequestMapping(value = "/test/entity")
@Slf4j
public class EntityCtrl {

    /**
     * 测试ResponseEntity简单对象
     *
     * @public
     */
    @RequestMapping("/int")
    public Mono<Integer> intInEntity(
            @RequestHeader("token") String token) {
        log.info("接收到token: {}", token);
        return Mono.just(65536);
    }

    /**
     * 测试ResponseEntity复合对象
     *
     * @public
     */
    @RequestMapping("/double")
    public Mono<IResult> doubleInEntity(
            @RequestHeader("token") String token) {
        log.info("接收到token: {}", token);
        return Mono.just(Result.success(65536.0));
    }


}
