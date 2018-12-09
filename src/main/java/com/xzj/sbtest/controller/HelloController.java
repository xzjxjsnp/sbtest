package com.xzj.sbtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController class
 *
 * @author ppx
 * @date 2018/12/09
 */
@RestController
public class HelloController {

    @Autowired
    com.xzj.sbtest.properties.XxxProperties xxxProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot" + xxxProperties.getPpa() + xxxProperties.getPpb();
    }
}
