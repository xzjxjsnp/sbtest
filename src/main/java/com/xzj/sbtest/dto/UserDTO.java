package com.xzj.sbtest.dto;

import lombok.Data;

import java.util.Date;

/**
 * UserDTO class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Data
public class UserDTO {
    private String username;
    private String sex;
    private Integer age;
    private Date birthday;
}
