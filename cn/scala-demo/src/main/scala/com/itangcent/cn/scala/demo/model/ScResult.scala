package com.itangcent.cn.scala.demo.model

import com.itangcent.common.dto.IResult

import scala.beans.BeanProperty

class ScResult[T]() extends IResult() {

  @BeanProperty
  var code: Int = null //响应码

  @BeanProperty
  var msg: String = _ //响应消息

  @BeanProperty
  var data: T = _ //响应数据

  private def this(code: Int, msg: String, data: T) {
    this()
    this.code = code
    this.msg = msg
    this.data = data
  }

}

object ScResult {

  def success[T](data: T): ScResult[T] = {
    new ScResult(0, "success", data)
  }
}

