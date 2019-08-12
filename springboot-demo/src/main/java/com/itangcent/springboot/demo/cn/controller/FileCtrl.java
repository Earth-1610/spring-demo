package com.itangcent.springboot.demo.cn.controller;

import com.itangcent.springboot.demo.cn.dto.IResult;
import com.itangcent.springboot.demo.cn.dto.Result;
import com.itangcent.springboot.demo.cn.dto.UserDto;
import com.itangcent.springboot.demo.cn.model.UserInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户相关(附加文件)
 *
 * @module user
 */
@RestController
@RequestMapping(value = "file")
public class FileCtrl {
    /**
     * 增加新用户(上传头像)
     */
    @PostMapping("/add")
    public IResult add(@ModelAttribute UserDto userDto) {
        return Result.success("保存成功");
    }

    /**
     * 另一种增加新用户(上传头像)
     * 文件单独一个参数
     *
     * @undone
     */
    @PostMapping("/add2")
    public IResult add(UserInfo userInfo,
                       @RequestParam(name = "profileImg") MultipartFile profileImg) {
        return Result.success("保存成功");
    }

    /**
     * 试试上传多个头像
     *
     * @undone
     */
    @PostMapping("/add3")
    public IResult add(UserInfo userInfo,
                       @RequestParam(name = "profileImg") MultipartFile[] profileImgs) {
        return Result.success("保存成功");
    }
}
