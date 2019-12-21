package com.itangcent.springboot.demo.controller;


import com.itangcent.common.model.ValidationDemoDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 校验相关API
 */
@RestController
@RequestMapping(value = "/test/validation")
public class ValidationCtrl {

    /**
     * demo
     */
    @RequestMapping("/demo")
    public ValidationDemoDto demo(
            @RequestBody ValidationDemoDto validationDemoDto) {
        return validationDemoDto;
    }

}
