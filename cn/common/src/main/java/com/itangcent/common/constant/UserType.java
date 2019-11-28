package com.itangcent.common.constant;

/**
 * 用户类型
 */
public enum UserType {
    //管理员
    ADMIN(1, "管理员"),

    //成员
    MEMBER(2, "成员"),

    //游客
    GUEST(3, "游客");

    private int type;//用户类型

    private String desc;

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    UserType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
