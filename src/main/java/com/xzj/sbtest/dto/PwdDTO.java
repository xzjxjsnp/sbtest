package com.xzj.sbtest.dto;

import lombok.Data;

@Data
public class PwdDTO {
    private String username;
    private String oldpwd;
    private String newpwd;
}
