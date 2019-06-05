package com.itangcent.springboot.demo.cn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

public class TestJsonIgnoreBean {

    @Expose(serialize = true)
    private Long shouldNotIgnoreForGson;

    @Expose(serialize = false)
    private Long shouldIgnoreForGson;

    @JsonIgnore(false)
    private Long shouldNotIgnoreForJackson;

    @JsonIgnore
    private Long shouldIgnoreForJackson;

    public Long getShouldNotIgnoreForGson() {
        return shouldNotIgnoreForGson;
    }

    public void setShouldNotIgnoreForGson(Long shouldNotIgnoreForGson) {
        this.shouldNotIgnoreForGson = shouldNotIgnoreForGson;
    }

    public Long getShouldIgnoreForGson() {
        return shouldIgnoreForGson;
    }

    public void setShouldIgnoreForGson(Long shouldIgnoreForGson) {
        this.shouldIgnoreForGson = shouldIgnoreForGson;
    }

    public Long getShouldNotIgnoreForJackson() {
        return shouldNotIgnoreForJackson;
    }

    public void setShouldNotIgnoreForJackson(Long shouldNotIgnoreForJackson) {
        this.shouldNotIgnoreForJackson = shouldNotIgnoreForJackson;
    }

    public Long getShouldIgnoreForJackson() {
        return shouldIgnoreForJackson;
    }

    public void setShouldIgnoreForJackson(Long shouldIgnoreForJackson) {
        this.shouldIgnoreForJackson = shouldIgnoreForJackson;
    }
}
