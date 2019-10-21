package com.itangcent.springboot.demo.controller;


import com.itangcent.common.constant.UserType;
import com.itangcent.common.dto.UserDtoWithEnum;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
