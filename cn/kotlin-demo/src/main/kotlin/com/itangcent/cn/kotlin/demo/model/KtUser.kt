package com.itangcent.cn.kotlin.demo.model

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class KtUser {

    var id: Long? = null//用户id

    /**
     * @see [com.itangcent.common.constant.UserType]
     */
    var type: Int = 0//用户类型

    @NotBlank
    var name: String? = null//用户名

    //年龄
    @NotNull
    var age: Int? = null

    @Deprecated("It's a secret")
    var sex: Int? = null
}