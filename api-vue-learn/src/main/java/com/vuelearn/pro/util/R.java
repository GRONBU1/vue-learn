package com.vuelearn.pro.util;

import java.util.HashMap;

public class R extends HashMap<String,Object> {

    public R(){

    }
    public static R ok(String state,String message,Object data){
        R r = new R();
        r.put("success",1);
        r.put("message",message);
        r.put("state",state);
        r.put("data",data);
        return r;
    }
    public static R error(String state,String message,Object data){
        R r = new R();
        r.put("success",0);
        r.put("message",message);
        r.put("state",state);
        r.put("data",data);
        return r;
    }
    @Override
    public R put(String key, Object value) {
         super.put(key, value);
         return this;
    }
}
