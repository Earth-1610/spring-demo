package com.itangcent.cn.kotlin.demo.controller


import com.itangcent.common.model.TestJsonFieldBean
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.annotation.security.RolesAllowed


/**
 * 权限测试相关
 *
 * @test a
 */
@RestController
@RequestMapping(value = "/test/security")
class SecurityCtrl {

    /**
     * 测试需要角色权限才能登陆
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed")
    fun rolesAllowed(
            @RequestBody testJsonFieldBean: TestJsonFieldBean): TestJsonFieldBean {
        return testJsonFieldBean
    }

}
