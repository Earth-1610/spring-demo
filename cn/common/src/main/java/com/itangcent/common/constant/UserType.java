package com.itangcent.common.constant;

public enum UserType {
    ADMIN(1, "管理员"),
    MEMBER(2, "成员"),
    GUEST(3, "游客");

    int type;
    String desc;

    UserType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
