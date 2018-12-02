package com.xzj.sbtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @Value("${xxx}")
//    private String xxx;
    @Autowired
    com.xzj.sbtest.properties.xxxProperties xxxProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot"+xxxProperties.getPpa()+xxxProperties.getPpb();
    }
}
