package com.itangcent.cn.scala.demo.controller

import org.springframework.web.bind.annotation._

@RestController
class ScalaCollectionCtrl {

  /**
    * array demo
    */
  @RequestMapping(value = Array("/array"))
  def array(): Array[String] = {
    Array("hello world")
  }

  /**
    * list demo
    */
  @RequestMapping(value = Array("/list"))
  def list(): List[String] = {
    List("hello world")
  }

  /**
    * set demo
    */
  @RequestMapping(value = Array("/set"))
  def set(): Set[String] = {
    Set("hello world")
  }

  /**
    * map  demo
    */
  @RequestMapping(value = Array("/map"))
  def map(): Map[String, String] = {
    Map("hello" -> "world")
  }


}
