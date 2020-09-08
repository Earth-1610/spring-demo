package com.itangcent.cn.kotlin.demo.swagger.dto

import io.swagger.annotations.ApiModelProperty

class SwaggerModel {

    @ApiModelProperty(value = "字段A", required = true)
    @Deprecated("不再使用")
    var a: String? = null

}