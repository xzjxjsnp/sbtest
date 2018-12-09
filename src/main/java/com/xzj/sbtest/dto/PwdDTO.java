package com.xzj.sbtest.dto;

import lombok.Data;

/**
 * PwdDTO class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Data
public class PwdDTO {
    private String username;
    private String oldpwd;
    private String newpwd;
}
