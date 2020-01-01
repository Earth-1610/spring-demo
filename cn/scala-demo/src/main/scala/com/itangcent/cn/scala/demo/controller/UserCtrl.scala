package com.itangcent.cn.scala.demo.controller

import com.itangcent.cn.scala.demo.model.{ScResult, ScUser}
import com.itangcent.common.dto.Result
import com.itangcent.common.model.UserInfo
import org.springframework.web.bind.annotation._

@RestController
class UserCtrl {

  /**
    * 打个招呼
    */
  @RequestMapping(value = Array("/greeting"))
  def greeting(): String = {
    "hello world"
  }


  /**
    * 更新用户名
    * 改用 [[com.itangcent.cn.scala.demo.controller.UserCtrl.update]]
    * 改用 [[update]]
    *
    * @param id      用户id
    * @param newName 新的用户名
    * @param slogon  个人签名
    * @deprecated 改用 [[com.itangcent.cn.scala.demo.controller.UserCtrl.update]]
    */
  @RequestMapping(method = Array(RequestMethod.PUT), value = Array("/set"))
  @Deprecated("改用 [[com.itangcent.cn.scala.demo.controller.UserCtrl.update]]")
  def set(id: Long,
          @RequestParam newName: String,
          @RequestParam(required = false, defaultValue = "haha") slogon: String,
          @RequestParam(required = false, defaultValue = "10") times: Long): Result[UserInfo] = {
    val userInfo: UserInfo = new UserInfo()
    userInfo.setId(id)
    userInfo.setName(newName)
    Result.success(userInfo)
  }

  /**
    * 更新用户信息
    */
  @PutMapping("update")
  def update(@ModelAttribute userInfo: ScUser): ScResult[ScUser] = {
    ScResult.success(userInfo)
  }


  /**
    * 批量更新用户信息
    */
  @PostMapping("updateBatch")
  def updateBatch(@RequestBody userInfo: Array[ScUser]): ScResult[Array[ScUser]] = {
    ScResult.success(userInfo)
  }

}
