package com.xzj.sbtest.utils;

import lombok.Data;

/**
 * Result<T> class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
