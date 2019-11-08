package com.itangcent.springboot.demo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.springboot.demo.UserContent;
import com.itangcent.springboot.demo.UserContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 忽略自定义注解参数
 */
@RestController
@RequestMapping("/testParamsWithCustomAnno")
public class WithCustomAnnController {


    /**
     * 忽略自定义注解参数
     * //     * @param userDtoWithEnum 用户Dto与枚举
     *
     * @param userContent 用户内容
     * @return {@link com.itangcent.common.dto.IResult}
     */
    @PostMapping("")
    public IResult testParamsWithCustomAnno(@UserContext UserContent userContent) {
        return Result.success("ok");
    }


}
