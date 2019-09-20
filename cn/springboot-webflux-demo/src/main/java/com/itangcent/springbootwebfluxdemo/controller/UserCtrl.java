package com.itangcent.springbootwebfluxdemo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Collections;

/**
 * 用户相关
 *
 * @module user
 */
@RestController
@RequestMapping(value = "user")
public class UserCtrl {

    /**
     * 打个招呼
     */
    @RequestMapping(value = "/index")
    public Mono<String> greeting() {
        return Mono.just("hello world");
    }

    /**
     * 更新用户名
     *
     * @param id      用户id
     * @param newName 新的用户名
     * @param slogon  个人签名
     * @deprecated 改用{@link #update(UserInfo)}
     */
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public Mono<Object> set(long id,
                            @RequestParam String newName,
                            @RequestParam(required = false, defaultValue = "haha") String slogon,
                            @RequestParam(required = false, defaultValue = "10") long times) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Mono.just(Result.success(userInfo));
    }

    /**
     * 获取用户信息
     *
     * @param id 用户id
     */
    @Deprecated
    @GetMapping("/get/{id}")
    public Mono<IResult> get(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Mono.just(Result.success(userInfo));
    }

    /**
     * 增加新用户
     */
    @PostMapping("/add")
    public Mono<Result<UserInfo>> add(@RequestBody UserInfo userInfo) {
        return Mono.just(Result.success(userInfo));
    }

    /**
     * 更新用户信息
     */
    @PutMapping("update")
    public Mono<IResult> update(@ModelAttribute UserInfo userInfo) {
        return Mono.just(Result.success(userInfo));
    }

    /**
     * 获取用户列表
     *
     * @param type 用户类型 {@link com.itangcent.common.constant.UserType}
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Mono<IResult> list(Integer type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Mono.just(Result.success(Collections.singletonList(userInfo)));
    }

    /**
     * 获取指定类型用户列表
     *
     * @param type 用户类型 {@link com.itangcent.common.constant.UserType}
     */
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    public Mono<IResult> listTypeInPath(@PathVariable("type") Integer type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        userInfo.setType(type);
        return Mono.just(Result.success(Collections.singletonList(userInfo)));
    }

    /**
     * 删除用户信息
     *
     * @param id 用户id
     */
    @DeleteMapping("/{id}")
    public Mono delete(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Mono.just(Result.success(userInfo));
    }

}
