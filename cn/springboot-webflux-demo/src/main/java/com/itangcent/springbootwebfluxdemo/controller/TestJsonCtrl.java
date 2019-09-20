package com.itangcent.springbootwebfluxdemo.controller;


import com.itangcent.common.model.TestJsonFieldBean;
import com.itangcent.common.model.TestJsonIgnoreBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


/**
 * Json字段测试相关
 *
 * @test a
 */
@RestController
@RequestMapping(value = "/test/json")
public class TestJsonCtrl {

    /**
     * 测试json字段名
     *
     * @public
     */
    @RequestMapping("/field")
    public Mono<TestJsonFieldBean> field(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return Mono.just(testJsonFieldBean);
    }

    /**
     * 测试json字段忽略
     */
    @RequestMapping("/ignore")
    public Mono<TestJsonIgnoreBean> ignore(
            @RequestBody TestJsonIgnoreBean testJsonIgnoreBean) {
        return Mono.just(testJsonIgnoreBean);
    }
}
