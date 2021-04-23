package com.itangcent.common.model;

import com.itangcent.common.constant.Add;
import com.itangcent.common.constant.Update;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ValidationGroupedDemoDto {

    @NotNull(groups = Add.class)
    private String str;

    @NotEmpty(groups = Update.class)
    private String notEmpty;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getNotEmpty() {
        return notEmpty;
    }

    public void setNotEmpty(String notEmpty) {
        this.notEmpty = notEmpty;
    }
}
