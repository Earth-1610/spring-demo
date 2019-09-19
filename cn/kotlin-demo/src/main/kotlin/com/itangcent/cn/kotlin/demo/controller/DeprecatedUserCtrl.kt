package com.itangcent.cn.kotlin.demo.controller

import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation.*

import java.util.Collections

/**
 * 用户相关(已废弃)
 *
 * @module user
 */
@Deprecated("")
@RestController
@RequestMapping(value = ["/user/deprecated"])
class DeprecatedUserCtrl {

    /**
     * 打个招呼
     */
    @Deprecated("")
    @RequestMapping(value = ["/index"])
    fun greeting(): String {
        return "hello world"
    }

    /**
     *
     * 更新用户名
     *
     * @param id      用户id
     * @param newName 新的用户名
     */
    @RequestMapping(value = ["/set"], method = [RequestMethod.PUT, RequestMethod.GET])
    @Deprecated("改用{@link #update(UserInfo)}")
    operator fun set(id: Long?, newName: String): Any {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = newName
        userInfo.age = 45
        return Result.success(userInfo)
    }

    /**
     * 获取用户信息
     *
     * @param id 用户id
     */
    @GetMapping("/get/{id}")
    operator fun get(@PathVariable("id") id: Long?): IResult {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = "Tony Stark"
        userInfo.age = 45
        return Result.success(userInfo)
    }

    /**
     * 增加新用户
     */
    @PostMapping("/add")
    fun add(@RequestBody userInfo: UserInfo): IResult {
        return Result.success(userInfo)
    }

    /**
     * 更新用户信息
     */
    @PutMapping("update")
    fun update(@ModelAttribute userInfo: UserInfo): IResult {
        return Result.success(userInfo)
    }

    /**
     * 获取用户列表
     */
    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(): IResult {
        val userInfo = UserInfo()
        userInfo.id = 1L
        userInfo.name = "Tom"
        userInfo.age = 25
        return Result.success(listOf(userInfo))
    }

    /**
     * 删除用户信息
     *
     * @param id 用户id
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long?): IResult {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = "Tony Stark"
        userInfo.age = 45
        return Result.success(userInfo)
    }

}
