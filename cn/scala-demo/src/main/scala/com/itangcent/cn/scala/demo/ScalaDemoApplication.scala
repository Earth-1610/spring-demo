package com.itangcent.cn.scala.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class ScalaDemoConfig {

}


object ScalaDemoApplication extends App {
  SpringApplication.run(classOf[ScalaDemoConfig])
}
