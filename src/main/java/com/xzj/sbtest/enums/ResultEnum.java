package com.xzj.sbtest.enums;

public enum ResultEnum {
    SUCCESS(0, "成功"),
    FAILURE(1, "失败"),
    FAILED(111, "不及格啊兄弟！"),
    USEREXIST(2, "用户名已存在"),
    USERNOTEXIST(3, "用户名不存在"),
    PWDCHANGEFAILED(4, "更改密码失败"),
    OLDPWDWRONG(5, "旧密码错误");


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
