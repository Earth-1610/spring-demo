package com.itangcent.springboot.demo.cn.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserInfo {

    private Long id;//用户id

    @NotBlank
    private String name;//用户名

    //年龄
    @NotNull
    private Integer age;

    /**
     * @deprecated It's a secret
     */
    private Integer sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
