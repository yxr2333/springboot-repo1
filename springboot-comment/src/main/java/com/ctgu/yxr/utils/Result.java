package com.ctgu.yxr.utils;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
* Created by Intellij IDEA
* @Author: Xinrui Yu
* @Date: Created in 11:14 2021-11-03
*/
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
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
    public static Result failed(Object data){
        return resultData(ResultMsg.FAILED.code, data.toString(),ResultMsg.FAILED.status);
    }
    public static Result resultData(Integer code,String msg,String status,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setStatus(status);
        result.setData(data);
        return result;
    }
    public static Result resultData(Integer code,String msg,String status){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setStatus(status);
        return result;
    }
}
