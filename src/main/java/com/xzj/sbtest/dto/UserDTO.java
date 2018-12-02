package com.xzj.sbtest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String username;
    private String sex;
    private Integer age;
    private Date birthday;
}
