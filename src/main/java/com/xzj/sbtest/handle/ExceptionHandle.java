package com.xzj.sbtest.handle;

import com.xzj.sbtest.utils.Result;
import com.xzj.sbtest.exception.MsgErrorException;
import com.xzj.sbtest.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ExceptionHandle class
 *
 * @author ppx
 * @date 2018/12/09
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(MsgErrorException.class)
    @ResponseBody
    public Result errorExceptionHandler(MsgErrorException e){
        return new Result<>(e.getCode(),e.getMsg(),null);
    }

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    public Result userExceptionHandler(UserNotExistException e){
        return new Result<>(e.getCode(),e.getMsg(),null);
    }
}
