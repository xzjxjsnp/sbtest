package com.xzj.sbtest.handle;

import com.xzj.sbtest.utils.Result;
import com.xzj.sbtest.exception.MsgErrorException;
import com.xzj.sbtest.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(MsgErrorException.class)
    @ResponseBody
    public Result ErrorExceptionHandler(MsgErrorException e){
        return new Result<>(e.getCode(),e.getMsg(),null);
    }

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    public Result UserExceptionHandler(UserNotExistException e){
        return new Result<>(e.getCode(),e.getMsg(),null);
    }
}
