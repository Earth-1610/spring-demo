package com.itangcent.springboot.demo.cn.controller;


import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 简单测试相关
 */
@RestController
@RequestMapping(value = "/test")
public class TestCtrl {


    /**
     * 测试RequestHeader
     *
     * @param token 传入token
     * @return token回传
     */
    @RequestMapping("/header")
    public String header(
            @RequestHeader("token") String token) {
        return token;
    }

    /**
     * 测试被忽略的方法
     *
     * @ignore
     */
    @RequestMapping("/ignore")
    public String ignore() {
        return "ignore";
    }

    /**
     * 测试javax.servlet.http.HttpServletRequest
     */
    @RequestMapping("/httpServletRequest")
    public String request(HttpServletRequest httpServletRequest) {
        return "javax.servlet.http.HttpServletRequest";
    }

    /**
     * 测试javax.servlet.http.HttpServletResponse
     */
    @RequestMapping("/httpServletResponse")
    public String response(HttpServletResponse httpServletResponse) {
        return "javax.servlet.http.HttpServletResponse";
    }
}
