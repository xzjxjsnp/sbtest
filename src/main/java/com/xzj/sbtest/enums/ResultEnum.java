package com.xzj.sbtest.enums;

/**
 * ResultEnum Enum
 *
 * @author ppx
 * @date 2018/12/09
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 失败
     */
    FAILURE(1, "失败"),
    /**
     * 不及格啊兄弟
     */
    FAILED(111, "不及格啊兄弟！"),
    /**
     * 用户名已存在
     */
    USEREXIST(2, "用户名已存在"),
    /**
     * 用户名不存在
     */
    USERNOTEXIST(3, "用户名不存在"),
    /**
     * 更改密码失败
     */
    PWDCHANGEFAILED(4, "更改密码失败"),
    /**
     * 旧密码错误
     */
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
