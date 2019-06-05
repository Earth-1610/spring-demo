package com.itangcent.springboot.demo.cn.controller;


import com.itangcent.springboot.demo.cn.model.TestJsonFieldBean;
import com.itangcent.springboot.demo.cn.model.TestJsonIgnoreBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Json字段测试相关
 */
@RestController
@RequestMapping(value = "/test/json")
public class TestJsonCtrl {

    /**
     * 测试json字段名
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
}
