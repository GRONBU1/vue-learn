package com.vuelearn.pro.util;


import java.util.HashMap;

public class JsonResult{
    //  成功标志
    private Integer success;
    //    状态
    private String state;
    //    错误信息
    private String message;
    //    json 数据对象
    private Object data;

    public JsonResult(Integer success, String state, String message, Object data) {
        this.success = success;
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public static JsonResult ok(String state,String message,Object data){
        return new JsonResult(1,state,message,data);
    }
    public static JsonResult error(String state,String message,Object data){
        return new JsonResult(0,state,message,data);
    }


    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
