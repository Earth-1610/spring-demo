package com.itangcent.cn.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.dto.UserDto
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * 用户相关(附加文件)
 *
 * @module user
 */
@RestController
@RequestMapping(value = "file")
class FileCtrl {
    /**
     * 增加新用户(上传头像)
     */
    @PostMapping("/add")
    fun add(@ModelAttribute userDto: UserDto): IResult {
        return Result.success("保存成功")
    }

    /**
     * 另一种增加新用户(上传头像)
     * 文件单独一个参数
     *
     * @undone
     */
    @PostMapping("/add2")
    fun add(userInfo: UserInfo,
            @RequestParam(name = "profileImg") profileImg: MultipartFile): IResult {
        return Result.success("保存成功")
    }

    /**
     * 试试上传多个头像
     *
     * @undone
     */
    @PostMapping("/add3")
    fun add(userInfo: UserInfo,
            @RequestParam(name = "profileImg") profileImgs: Array<MultipartFile>): IResult {
        return Result.success("保存成功")
    }
}