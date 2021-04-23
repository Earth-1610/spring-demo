package com.itangcent.springboot.demo.controller;


import com.itangcent.common.constant.Add;
import com.itangcent.common.constant.Update;
import com.itangcent.common.model.ValidationDemoDto;
import com.itangcent.common.model.ValidationGroupedDemoDto;
import org.springframework.validation.annotation.Validated;
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

    /**
     * demo-add
     */
    @RequestMapping("/demo/add")
    public void demoAdd(
            @Validated(Add.class) @RequestBody ValidationGroupedDemoDto validationGroupedDemoDto) {
        return;
    }

    /**
     * demo-update
     */
    @RequestMapping("/demo/update")
    public void demoUpdate(
            @Validated(Update.class) @RequestBody ValidationGroupedDemoDto validationGroupedDemoDto) {
        return;
    }

}
