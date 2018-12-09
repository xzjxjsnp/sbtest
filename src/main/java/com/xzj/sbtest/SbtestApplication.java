package com.xzj.sbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SbtestApplication class
 *
 * @author ppx
 * @date 2018/12/09
 */
@SpringBootApplication
@MapperScan(basePackages = "com.xzj.sbtest")
public class SbtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbtestApplication.class, args);
    }
}
