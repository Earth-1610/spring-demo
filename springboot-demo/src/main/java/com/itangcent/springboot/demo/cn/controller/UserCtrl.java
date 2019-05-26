package com.itangcent.springboot.demo.cn.controller;

import com.itangcent.springboot.demo.cn.model.UserInfo;
import com.itangcent.springboot.demo.cn.dto.Result;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关
 */
@RestController
@RequestMapping(value = "/user")
public class UserCtrl {

    /**
     * 打个招呼
     */
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
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public Result<UserInfo> set(Long id, String newName) {

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
    public Result<UserInfo> get(@PathVariable("id") Long id) {
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
    public Result<UserInfo> add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/update")
    public Result<UserInfo> update(@ModelAttribute UserInfo userInfo) {
        return Result.success(userInfo);
    }
}
