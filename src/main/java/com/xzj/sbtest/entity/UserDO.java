package com.xzj.sbtest.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * UserDO class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Data
@Table(name = "xzjuser")
public class UserDO {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private Integer age;
    private Date birthday;
}
