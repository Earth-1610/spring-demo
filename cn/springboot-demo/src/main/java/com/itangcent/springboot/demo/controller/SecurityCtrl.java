package com.itangcent.springboot.demo.controller;

import com.itangcent.common.model.TestJsonFieldBean;
import org.springframework.security.access.prepost.PreAuthorize;
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
     * 测试需要自定义角色权限才能登陆
     */
    @RolesAllowed("admin")
    @RequestMapping("/rolesAllowed/custom")
    public TestJsonFieldBean rolesAllowedCustom(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

    /**
     * 测试需要admin权限才能登陆
     */
    @PreAuthorize("hasRole('admin')")
    @RequestMapping("/rolesAllowed/admin")
    public TestJsonFieldBean rolesAllowedAdmin(
            @RequestBody TestJsonFieldBean testJsonFieldBean) {
        return testJsonFieldBean;
    }

}
