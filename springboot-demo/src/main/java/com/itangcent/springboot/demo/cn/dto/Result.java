package com.itangcent.springboot.demo.cn.dto;

public class Result<T> implements IResult {

    private Integer code;//响应码

    private String msg;//响应消息

    private T data;//响应数据

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> IResult success(T data) {
        return new Result<>(0, "success", data);
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
