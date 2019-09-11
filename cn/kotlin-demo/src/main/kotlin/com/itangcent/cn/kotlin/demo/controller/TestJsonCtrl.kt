package com.itangcent.cn.kotlin.demo.controller


import com.itangcent.common.model.TestJsonFieldBean
import com.itangcent.common.model.TestJsonIgnoreBean
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Json字段测试相关
 *
 * @test a
 */
@RestController
@RequestMapping("/test/json")
class TestJsonCtrl {

    /**
     * 测试json字段名
     *
     * @public
     */
    @RequestMapping("/field")
    fun field(
            @RequestBody testJsonFieldBean: TestJsonFieldBean): TestJsonFieldBean {
        return testJsonFieldBean
    }

    /**
     * 测试json字段忽略
     */
    @RequestMapping("/ignore")
    fun ignore(
            @RequestBody testJsonIgnoreBean: TestJsonIgnoreBean): TestJsonIgnoreBean {
        return testJsonIgnoreBean
    }
}
