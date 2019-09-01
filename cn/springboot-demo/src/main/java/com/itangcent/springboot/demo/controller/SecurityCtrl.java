package com.itangcent.springboot.demo.controller;


import com.itangcent.common.model.TestJsonFieldBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;


/**
 * 权限测试相关
 *
 * @test a
 */
@RestController
@RequestMapping(value = "/test/security")
public class SecurityCtrl {

    /**
     * 测试需要角色权限才能登陆
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed")
    public TestJsonFieldBean rolesAllowed(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

}
