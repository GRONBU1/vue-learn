package com.vuelearn.pro.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.deploy.net.HttpResponse;
import com.vuelearn.pro.entity.Vlearnprod;
import com.vuelearn.pro.service.VlearnprodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Gronbu1
 * @since 2019-05-27
 */
@RestController
@RequestMapping("/api")
public class VlearnprodController {
    @Autowired
    private VlearnprodService vlearnprodService;

    @GetMapping("/getJson")
    @ResponseBody
    public Map<String,Object> getJson(ServletResponse res){
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
       List<Vlearnprod> list = new ArrayList<>();
       list = vlearnprodService.list();
       Map<String,Object> mapData = new HashMap<>();
       mapData.put("status",0);
       mapData.put("message",list);
       return mapData;
    }


    @PostMapping("/addObj")
    @ResponseBody
    public Map<String,Object> addObj(@RequestParam Map<String,Object> params,ServletResponse res){
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("access-control-allow-methods","GET, POST, OPTIONS, PUT, DELETE");

        Map<String,Object> mapData = new HashMap<>();
        JSONObject jsonObject = new JSONObject(params);
        Vlearnprod vlearnprod = JSONObject.parseObject(jsonObject.toString(),Vlearnprod.class);
        vlearnprod.setDate(new Date());
        if (vlearnprodService.save(vlearnprod)){
            mapData.put("status",0);
            mapData.put("message","添加成功");
            return mapData;
        }else{
            mapData.put("status",1);
            mapData.put("message","添加失败");
            return mapData;
        }
    }

    @GetMapping("/delObj")
    @ResponseBody
    public Map<String,Object> delObj(@RequestParam Map<String,Object> params,ServletResponse res){
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        Map<String,Object> mapData = new HashMap<>();
        QueryWrapper<Vlearnprod> queryWrapper = new QueryWrapper<Vlearnprod>();
        queryWrapper.eq("id",params.get("id"));
        if (vlearnprodService.remove(queryWrapper)){
            mapData.put("status",0);
            mapData.put("message","删除成功");
            return mapData;
        }else{
            mapData.put("status",1);
            mapData.put("message","删除失败");
            return mapData;
        }
    }
}

