package com.itangcent.springboot.demo.controller;

import com.itangcent.common.dto.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 内部类测试
 *
 * @module user
 */
@RestController
@RequestMapping(value = "inner")
public class InnerClassCtrl extends BaseController {

    /**
     * 增加新用户
     */
    @PostMapping("/add")
    public Result<UserInfo> add(@RequestBody UserInfo userInfo) {
        return Result.success(userInfo);
    }

    public static class UserInfo {

        private Long id;//用户id

        /**
         * @see com.itangcent.common.constant.UserType
         */
        private int type;//用户类型

        @NotBlank
        private String name;//用户名

        //年龄
        @NotNull
        private Integer age;

        /**
         * @deprecated It's a secret
         */
        private Integer sex;

        //生日
        private LocalDate birthDay;

        //注册时间
        private LocalDateTime regtime;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public LocalDate getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(LocalDate birthDay) {
            this.birthDay = birthDay;
        }

        public LocalDateTime getRegtime() {
            return regtime;
        }

        public void setRegtime(LocalDateTime regtime) {
            this.regtime = regtime;
        }
    }

}
