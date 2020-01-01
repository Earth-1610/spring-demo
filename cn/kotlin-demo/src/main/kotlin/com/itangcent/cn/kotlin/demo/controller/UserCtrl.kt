package com.itangcent.cn.kotlin.demo.controller

import com.itangcent.cn.kotlin.demo.model.KtResult
import com.itangcent.cn.kotlin.demo.model.KtUser
import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation.*

/**
 * 用户相关
 *
 * @module user
 */
@RestController
@RequestMapping(value = ["user"])
class UserCtrl {

    /**
     * 打个招呼
     */
    @RequestMapping(value = ["/index"])
    fun greeting(): String {
        return "hello world"
    }


    /**
     * 更新用户名
     * 改用 [update]
     *
     * @param id      用户id
     * @param newName 新的用户名
     * @param slogon  个人签名
     * @deprecated 改用 [com.itangcent.cn.kotlin.demo.controller.UserCtrl.update]
     */
    @RequestMapping(method = [RequestMethod.PUT], value = ["/set"])
    @Deprecated("改用 [com.itangcent.cn.kotlin.demo.controller.UserCtrl.update]")
    fun set(id: Long,
            @RequestParam newName: String,
            @RequestParam(required = false, defaultValue = "haha") slogon: String,
            @RequestParam(required = false, defaultValue = "10") times: Long): Any {

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
    @Deprecated("")
    @GetMapping("/get/{id}")
    fun get(@PathVariable("id") id: Long?): IResult {
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
    fun add(@RequestBody userInfo: KtUser): KtResult<KtUser> {
        return KtResult.success(userInfo)
    }

    /**
     * 更新用户信息
     */
    @PutMapping("update")
    fun update(@ModelAttribute userInfo: KtUser): Result<*> {
        return Result.success(userInfo)
    }


    /**
     * 获取用户列表
     *
     * @param type 用户类型 [com.itangcent.common.constant.UserType]
     */
    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(type: Int?): IResult {
        val userInfo = UserInfo()
        userInfo.id = 1L
        userInfo.name = "Tom"
        userInfo.age = 25
        return Result.success(listOf(userInfo))
    }

    /**
     * 获取指定类型用户列表
     *
     * @param type 用户类型 [com.itangcent.common.constant.UserType]
     */
    @RequestMapping(value = ["/list/{type}"], method = [RequestMethod.GET])
    fun listTypeInPath(@PathVariable("type") type: Int?): IResult {
        val userInfo = UserInfo()
        userInfo.id = 1L
        userInfo.name = "Tom"
        userInfo.age = 25
        userInfo.type = type!!
        return Result.success(listOf(userInfo))
    }

    /**
     * 删除用户信息
     *
     * @param id 用户id
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long?): Any {
        val userInfo = UserInfo()
        userInfo.id = id
        userInfo.name = "Tony Stark"
        userInfo.age = 45
        return Result.success(userInfo)
    }

}
