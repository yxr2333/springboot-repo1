package com.example.web.springbootweb.utils;
/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 21:36 2021-11-02
*/
public enum ResultMsg {
    /*成功*/
    SUCCESS(5000,"success","ok"),
    /*失败*/
    FAILED(4000,"failed","failed"),
    ERROR(4001,"error","error");


    ResultMsg(Integer code, String msg, String status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
    public String msg;
    public Integer code;
    public String status;
}
