package com.itangcent.springboot.demo.controller;


import com.itangcent.common.constant.UserType;
import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.dto.UserDtoWithEnum;
import com.itangcent.common.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


/**
 * 枚举测试相关
 */
@RestController
@RequestMapping(value = "/test/enum")
public class TestEnumCtrl {

    /**
     * 测试字段类型为枚举
     *
     * @public
     */
    @RequestMapping("/echo")
    public UserDtoWithEnum echo(
            @RequestBody UserDtoWithEnum userDtoWithEnum) {
        userDtoWithEnum.setType(UserType.ADMIN);
        return userDtoWithEnum;
    }


    /**
     * 获取用户列表
     * (测试@RequestParam 枚举)
     *
     * @param type 用户类型
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public IResult list(@RequestParam UserType type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }

    /**
     * 获取指定类型用户列表
     * (测试@PathVariable 枚举)
     *
     * @param type 用户类型
     */
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    public IResult listByPath(@PathVariable("type") UserType type) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1l);
        userInfo.setName("Tom");
        userInfo.setAge(25);
        return Result.success(Collections.singletonList(userInfo));
    }

}
