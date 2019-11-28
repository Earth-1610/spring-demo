package com.itangcent.springboot.demo.swagger.dto;

import io.swagger.annotations.ApiModelProperty;

public class SwaggerModel {

    /**
     * @deprecated 不再使用
     */
    @ApiModelProperty(value = "字段A", required = true)
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
