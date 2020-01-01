package com.itangcent.cn.scala.demo.model

import javax.validation.constraints.{NotBlank, NotNull}

import scala.beans.BeanProperty

class ScUser() {

  @BeanProperty
  var id: Long = null //用户id

  /**
    * @see [[com.itangcent.cn.scala.demo.constant.ScUserType]]
    */
  @BeanProperty
  var `type`: Int = 0 //用户类型

  @NotBlank
  @BeanProperty
  var name: String = _ //用户名

  //年龄
  @NotNull
  @BeanProperty
  var age: Int = null

  @BeanProperty
  @Deprecated("It's a secret")
  var sex: Int = null
}