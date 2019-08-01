package com.itangcent.springboot.demo.cn.dto;

import com.itangcent.springboot.demo.cn.model.UserInfo;
import org.springframework.web.multipart.MultipartFile;

public class UserDto extends UserInfo {

    /**
     * 头像
     */
    private MultipartFile profileImg;

    public MultipartFile getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(MultipartFile profileImg) {
        this.profileImg = profileImg;
    }
}
