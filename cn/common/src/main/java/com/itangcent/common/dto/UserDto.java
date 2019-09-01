package com.itangcent.common.dto;

import com.itangcent.common.model.UserInfo;
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
