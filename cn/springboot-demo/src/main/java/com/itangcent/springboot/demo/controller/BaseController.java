package com.itangcent.springboot.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class BaseController {

    /**
     * 当前ctrl名称
     *
     * @public
     */
    @RequestMapping("/ctrl/name")
    public String ctrlName() {
        return getClass().getName();
    }

}
