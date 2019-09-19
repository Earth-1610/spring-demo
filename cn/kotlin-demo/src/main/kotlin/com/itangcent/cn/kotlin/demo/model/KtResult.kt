package com.itangcent.cn.kotlin.demo.model

import com.itangcent.common.dto.IResult

class KtResult<T> : IResult {

    private var code: Int? = null//响应码

    private var msg: String? = null//响应消息

    var data: T? = null//响应数据

    constructor() {}

    constructor(code: Int?, msg: String, data: T) {
        this.code = code
        this.msg = msg
        this.data = data
    }

    override fun getCode(): Int? {
        return code
    }

    fun setCode(code: Int?) {
        this.code = code
    }

    override fun getMsg(): String? {
        return msg
    }

    fun setMsg(msg: String) {
        this.msg = msg
    }

    companion object {

        fun <T> success(data: T): KtResult<T> {
            return KtResult(0, "success", data)
        }
    }
}
