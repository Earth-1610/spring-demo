package com.itangcent.cn.kotlin.demo.controller


import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import org.springframework.http.HttpEntity
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Entity相关
 */
@RestController
@RequestMapping(value = "/test/entity")
class EntityCtrl {

    /**
     * 测试ResponseEntity简单对象
     *
     * @public
     */
    @RequestMapping("/int")
    fun intInEntity(
            @RequestHeader("token") token: String,
            @RequestBody requestEntity: RequestEntity<Int>): ResponseEntity<Int> {
        return ResponseEntity.ok(65536)
    }

    /**
     * 测试ResponseEntity复合对象
     *
     * @public
     */
    @RequestMapping("/double")
    fun doubleInEntity(
            @RequestHeader("token") token: String,
            @RequestBody requestEntity: RequestEntity<UserInfo>): ResponseEntity<IResult> {
        return ResponseEntity.ok(Result.success(65536.0))
    }

    /**
     * 测试HttpEntity
     */
    @RequestMapping("/user")
    fun userInEntity(
            @RequestHeader("token") token: String): HttpEntity<IResult> {
        val userInfo = UserInfo()
        userInfo.age = 18
        return ResponseEntity.ok(Result.success(userInfo))
    }

}
