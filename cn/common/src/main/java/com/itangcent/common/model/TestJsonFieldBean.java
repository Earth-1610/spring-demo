package com.itangcent.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class TestJsonFieldBean {
    @JsonProperty("a")
    private Long propertyA;

    @SerializedName("b")
    private Long propertyB;

    public Long getPropertyA() {
        return propertyA;
    }

    public void setPropertyA(Long propertyA) {
        this.propertyA = propertyA;
    }

    public Long getPropertyB() {
        return propertyB;
    }

    public void setPropertyB(Long propertyB) {
        this.propertyB = propertyB;
    }
}
