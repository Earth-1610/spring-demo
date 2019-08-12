package com.itangcent.springboot.demo.cn.controller;


import com.itangcent.springboot.demo.cn.dto.IResult;
import com.itangcent.springboot.demo.cn.dto.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


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
     * 测试数组参数
     *
     * @param strings 字符串参数
     * @param ints    整型参数
     */
    @RequestMapping("/arrays")
    public String header(@RequestParam(name = "string") String[] strings,
                         @RequestParam(name = "int") int[] ints) {
        return "ok";
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


    /**
     * 推断包含集合的响应
     */
    @RequestMapping(value = "/interWithCollection", method = RequestMethod.POST)
    public IResult interWithCollection(@PathVariable("id") Long id) {
        List<Map> list = new LinkedList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "string");//这是个测试的key
        map.put("key2", 666);//这是个测试的666
        Map<String, Object> value3 = new HashMap<>();
        value3.put("subKey", "string");//这是个测试的子对象的key
        map.put("key3", value3);//这是个测试的子对象
        list.add(map);
        return Result.success(list);
    }
}
