package com.example.spring.utils;


import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String msg;
    private String status;
    private Object data;

    public static Result success(Object data){
        return resultData(ResultMsg.SUCCESS.code,ResultMsg.SUCCESS.msg, ResultMsg.SUCCESS.status,data);
    }
    public static Result success(Object data,String msg){
        return resultData(ResultMsg.SUCCESS.code, msg,ResultMsg.SUCCESS.status, data);
    }
    public static Result resultData(Integer code,String msg,String status,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setStatus(status);
        result.setData(data);
        return result;
    }
}
