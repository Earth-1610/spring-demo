package com.itangcent.springbootwebfluxdemo.controller;

import com.itangcent.common.dto.IResult;
import com.itangcent.common.dto.Result;
import com.itangcent.common.dto.UserDto;
import com.itangcent.common.model.UserInfo;
import com.itangcent.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

/**
 * 用户相关(附加文件)
 *
 * @module user
 */
@RestController
@RequestMapping(value = "file")
@Slf4j
public class FileCtrl {
    /**
     * 增加新用户(上传头像)
     */
    @PostMapping("/add")
    public Mono<IResult> add(@ModelAttribute UserDto userDto) {
        log.info("接收到参数: {}", JsonUtil.toJson(userDto));
        return Mono.just(Result.success("保存成功"));
    }

    /**
     * 另一种增加新用户(上传头像)
     * 文件单独一个参数
     *
     * @undone
     */
    @PostMapping("/add2")
    public Mono<IResult> add(UserInfo userInfo,
                             @RequestParam(name = "profileImg") MultipartFile profileImg) {
        return Mono.just(Result.success("保存成功"));
    }

    /**
     * 试试上传多个头像
     *
     * @undone
     */
    @PostMapping("/add3")
    public Mono<IResult> add(UserInfo userInfo,
                             @RequestParam(name = "profileImg") MultipartFile[] profileImgs) {
        return Mono.just(Result.success("保存成功"));
    }
}
