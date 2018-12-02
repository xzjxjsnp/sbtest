package com.xzj.sbtest.exception;

import com.xzj.sbtest.enums.ResultEnum;
import lombok.Data;

@Data
public class MsgErrorException extends RuntimeException {
    private Integer code;
    private String msg;

    public MsgErrorException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }
}
