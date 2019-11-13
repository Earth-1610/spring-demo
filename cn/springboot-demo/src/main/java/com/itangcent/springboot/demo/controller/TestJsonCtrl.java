package com.itangcent.springboot.demo.controller;


import com.itangcent.common.model.TestJsonFieldBean;
import com.itangcent.common.model.TestJsonIgnoreBean;
import com.itangcent.common.model.TestLogBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public TestJsonFieldBean field(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

    /**
     * 测试json字段忽略
     */
    @RequestMapping("/ignore")
    public TestJsonIgnoreBean ignore(
            @RequestBody TestJsonIgnoreBean testJsonIgnoreBean) {
        return testJsonIgnoreBean;
    }

    /**
     * 测试transient字段忽略
     */
    @RequestMapping("/ignore/transient")
    public TestLogBean ignoreTransient(
            @RequestBody TestLogBean testLogBean) {
        return testLogBean;
    }
}
