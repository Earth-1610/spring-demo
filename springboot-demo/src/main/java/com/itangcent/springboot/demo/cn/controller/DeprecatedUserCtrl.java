package com.itangcent.springboot.demo.cn.controller;

import com.itangcent.springboot.demo.cn.dto.IResult;
import com.itangcent.springboot.demo.cn.dto.Result;
import com.itangcent.springboot.demo.cn.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * 用户相关(已废弃)
 *
 * @module user
 */
@Deprecated
@RestController
@RequestMapping(value = "/user/deprecated")
public class DeprecatedUserCtrl {

    /**
     * 打个招呼
     */
    @Deprecated
    @RequestMapping(value = "/index")
    public String greeting() {
        return "hello world";
    }

    /**
     * 更新用户名
     *
     * @param id      用户id
     * @param newName 新的用户名
     * @deprecated 改用{@link #update(UserInfo)}
     */
    @Deprecated
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public Object set(Long id, String newName) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * 获取用户信息
     *
     * @param id 用户id
     */
    @GetMapping("/get/{id}")
    public IResult get(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

    /**
     * 增加新用户
     */
    @PostMapping("/add")
    public IResult add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * 更新用户信息
     */
    @PutMapping("update")
    public IResult update(@ModelAttribute UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public IResult list() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * 删除用户信息
     *
     * @param id 用户id
     */
    @DeleteMapping("/{id}")
    public IResult delete(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

}
