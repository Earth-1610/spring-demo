package com.itangcent.springboot.demo.controller;


import com.itangcent.common.dto.Result;
import com.itangcent.common.model.UserInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Entity相关
 */
@RestController
@RequestMapping(value = "/test/entity")
public class EntityCtrl extends BaseController {

    /**
     * 测试ResponseEntity简单对象
     *
     * @public
     */
    @RequestMapping("/int")
    public ResponseEntity<Integer> intInEntity(
            @RequestHeader("token") String token,
            @RequestBody RequestEntity<Integer> requestEntity) {
        return ResponseEntity.ok(65536);
    }

    /**
     * 测试ResponseEntity
     *
     * @public
     */
    @RequestMapping("/nil")
    public ResponseEntity nilEntity() {
        return ResponseEntity.ok("nil");
    }

    /**
     * 测试ResponseEntity复合对象
     *
     * @public
     */
    @RequestMapping("/double")
    public ResponseEntity<Result<Double>> doubleInEntity(
            @RequestHeader("token") String token,
            @RequestBody RequestEntity<UserInfo> requestEntity) {
        return ResponseEntity.ok(Result.success(65536.0));
    }

    /**
     * 测试HttpEntity
     */
    @RequestMapping("/user")
    public HttpEntity<Result<UserInfo>> userInEntity(
            @RequestHeader("token") String token) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(18);
        return ResponseEntity.ok(Result.success(userInfo));
    }

}
