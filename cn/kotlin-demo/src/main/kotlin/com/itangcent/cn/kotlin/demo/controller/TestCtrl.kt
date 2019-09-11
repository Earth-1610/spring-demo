package com.itangcent.cn.kotlin.demo.controller


import com.itangcent.common.dto.IResult
import com.itangcent.common.dto.Result
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 * 简单测试相关
 */
@RestController
@RequestMapping(value = ["/test"])
class TestCtrl {

    /**
     * 测试RequestHeader
     *
     * @param token 传入token
     * @return token回传
     */
    @RequestMapping("/header")
    fun header(
            @RequestHeader("token") token: String): String {
        return token
    }

    /**
     * 测试数组参数
     *
     * @param strings 字符串参数
     * @param ints    整型参数
     */
    @RequestMapping("/arrays")
    fun header(@RequestParam(name = "string") strings: Array<String>,
               @RequestParam(name = "int") ints: IntArray): String {
        return "ok"
    }

    /**
     * 测试被忽略的方法
     *
     * @ignore
     */
    @RequestMapping("/ignore")
    fun ignore(): String {
        return "ignore"
    }

    /**
     * 测试javax.servlet.http.HttpServletRequest
     */
    @RequestMapping("/httpServletRequest")
    fun request(httpServletRequest: HttpServletRequest): String {
        return "javax.servlet.http.HttpServletRequest"
    }

    /**
     * 测试javax.servlet.http.HttpServletResponse
     */
    @RequestMapping("/httpServletResponse")
    fun response(httpServletResponse: HttpServletResponse): String {
        return "javax.servlet.http.HttpServletResponse"
    }


    /**
     * 推断包含集合的响应
     */
    @RequestMapping(value = ["/interWithCollection"], method = [RequestMethod.POST])
    fun interWithCollection(@PathVariable("id") id: Long?): IResult {
        val list = LinkedList<Map<*, *>>()
        val map = HashMap<String, Any>()
        map["key1"] = "string"//这是个测试的key
        map["key2"] = 666//这是个测试的666
        val value3 = HashMap<String, Any>()
        value3["subKey"] = "string"//这是个测试的子对象的key
        map["key3"] = value3//这是个测试的子对象
        list.add(map)
        return Result.success(list)
    }
}
