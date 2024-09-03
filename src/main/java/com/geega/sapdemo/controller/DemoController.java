package com.geega.sapdemo.controller;

import com.geega.sapjco3.config.SapJcoClientProperties;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Resource
    SapJcoClientProperties sapJcoClientProperties;

    @RequestMapping("/test")
    public String test(){
        return sapJcoClientProperties.getAshost()+"欢迎您";
    }

}