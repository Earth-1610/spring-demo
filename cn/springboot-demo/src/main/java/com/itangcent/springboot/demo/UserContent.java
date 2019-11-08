package com.itangcent.springboot.demo;

/**
 * 用户内容
 *
 * @author qinkangdeid
 * @date 2019/10/30
 */
public class UserContent {

    /**
     * userId
     */
    private Integer userId;

    public UserContent() {
    }

    public UserContent(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
