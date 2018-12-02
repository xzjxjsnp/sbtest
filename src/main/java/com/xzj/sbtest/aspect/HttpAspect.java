package com.xzj.sbtest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

//    @Before(value = "execution(public * com.xzj.sbtest.controller.StudentController.queryAll())")
//    public void log(){
//        System.out.println("xxxxxxxxxxxx");
//    }

    @Pointcut(value = "execution(public * com.xzj.sbtest.controller.StudentController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void after(Object object){
        logger.info("response={}", object.toString());
    }
}
