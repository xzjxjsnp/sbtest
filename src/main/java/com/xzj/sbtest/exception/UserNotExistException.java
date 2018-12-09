package com.xzj.sbtest.exception;

import com.xzj.sbtest.enums.ResultEnum;
import lombok.Data;

/**
 * UserNotExistException class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Data
public class UserNotExistException extends RuntimeException {
    private Integer code;
    private String msg;

    public UserNotExistException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }
}
