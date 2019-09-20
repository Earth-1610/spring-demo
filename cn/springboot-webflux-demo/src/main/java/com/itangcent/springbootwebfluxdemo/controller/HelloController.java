package com.itangcent.springbootwebfluxdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * @author layker
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("/")
    public Mono<String> hello() {
        return Mono.just("hello webflux, this is reactive world !");
    }
    
    /**
     * 测试Flux返回集合数据
     *
     * @public
     */
    @RequestMapping("/list")
    public Flux<Integer> list() {
        return Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5));
    }

}
