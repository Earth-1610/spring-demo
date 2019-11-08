package com.itangcent.springboot.demo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.springboot.demo.UserContent;
import com.itangcent.springboot.demo.UserContext;
import org.springframework.web.bind.annotation.*;

/**
 * 测试参数忽略
 */
@RestController
@RequestMapping("/testParamsWithCustomAnno")
public class WithCustomAnnController {

    /**
     * 忽略自定义注解参数
     *
     * @param paramShouldNotIgnore 不应该被忽略的参数
     * @param userContent          用户内容（系统自动给出,不会出现在API参数中）
     */
    @PostMapping("/custom/ann")
    public IResult testParamsWithCustomAnno(
            @RequestParam("notIgnore") String paramShouldNotIgnore,
            @UserContext UserContent userContent) {
        return Result.success("ok");
    }

    /**
     * 忽略系统自动填充的token
     *
     * @param paramShouldNotIgnore 不应该被忽略的参数
     * @param token                Token（系统自动给出,不会出现在API参数中）
     */
    @PostMapping("/auto/fill/token")
    public IResult testAutoFillToken(
            @RequestParam("notIgnore") String paramShouldNotIgnore,
            @RequestHeader("token") String token) {
        return Result.success("ok");
    }
}
