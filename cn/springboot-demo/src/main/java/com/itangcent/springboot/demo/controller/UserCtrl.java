package com.itangcent.springboot.demo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * 用户相关
 *
 * @module user
 */
@RestController
@RequestMapping(value = "user")
public class UserCtrl extends BaseController {

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
     * @param slogon  个人签名
     * @deprecated 改用{@link #update(UserInfo)}
     */
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public Object set(long id,
                      @RequestParam String newName,
                      @RequestParam(required = false, defaultValue = "haha") String slogon,
                      @RequestParam(required = false, defaultValue = "10") long times) {

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
    @Deprecated
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
    public Result<UserInfo> add(@RequestBody UserInfo userInfo) {
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
     *
     * @param type 用户类型 {@link com.itangcent.common.constant.UserType}
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public IResult list(Integer type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * 获取指定类型用户列表
     *
     * @param type 用户类型 {@link com.itangcent.common.constant.UserType}
     */
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    public IResult listTypeInPath(@PathVariable("type") Integer type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        userInfo.setType(type);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * 删除用户信息
     *
     * @param id 用户id
     */
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName("Tony Stark");
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

}
