package com.itangcent.springboot.demo.controller;

import com.itangcent.common.annotation.Public;
import com.itangcent.common.constant.UserType;
import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Public
    @RequestMapping(value = "/index")
    public String greeting() {
        return "hello world";
    }

    /**
     * 更新用户名
     *
     * @param id      当前用户id
     * @param newName 新的用户名
     * @param slogon  个人签名
     * @deprecated 改用{@link #update(UserInfo)}
     */
    @RequestMapping(value = "/set", method = RequestMethod.PUT)
    public Object set(@CookieValue(value = "currentId", required = false, defaultValue = "123") long id,
                      String newName,
                      @RequestParam String slogon,
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
     * @undone
     * @see {@link #getById(Long)}
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
     * 根据用户id获取用户信息
     *
     * @param id 用户id
     * @undone
     */
    @GetMapping(value = "/get", params = "id")
    public IResult getById(@RequestParam("id") Long id) {
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
    public IResult update(UserInfo userInfo) {
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
        userInfo.setId(1L);
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


    /**
     * 获取当前用户类型
     *
     * @return {@link com.itangcent.common.constant.UserTypeConstant}
     */
    @GetMapping("/type")
    public Result<Integer> currUserType() {
        return Result.success(UserType.values()[new Random(System.currentTimeMillis()).nextInt(UserType.values().length)].getType());
    }


    /**
     * 获取所有用户类型
     *
     * @return {@link com.itangcent.common.constant.UserType#getType()}
     */
    @GetMapping("/types")
    public Result<List<Integer>> types() {
        final List<Integer> types = Stream.of(UserType.values()).map(UserType::getType).collect(Collectors.toList());
        return Result.success(types);
    }

    /**
     * 更新用户名
     *
     * @param id      当前用户id
     * @param newName 新的用户名
     * @param slogon  个人签名
     * @tag a&zs, b, c
     * @deprecated 改用{@link #update(UserInfo)}
     */
    @RequestMapping(value = "/set")
    public Object setName(@CookieValue(value = "currentId", required = false, defaultValue = "123") long id,
                          String newName,
                          @RequestParam(required = false, name = "slogon2") String slogon1,
                          @RequestParam String slogon
    ) {

        UserInfo userInfo = new UserInfo();

        userInfo.setId(id);
        userInfo.setName(newName);
        userInfo.setAge(45);
        return Result.success(userInfo);
    }

}
