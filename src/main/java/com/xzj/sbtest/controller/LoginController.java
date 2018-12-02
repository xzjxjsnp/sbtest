package com.xzj.sbtest.controller;

import com.xzj.sbtest.service.UserService;
import com.xzj.sbtest.utils.Result;
import com.xzj.sbtest.entity.UserDO;
import com.xzj.sbtest.enums.ResultEnum;
import com.xzj.sbtest.exception.UserNotExistException;
import com.xzj.sbtest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public Result<UserDO> login(@RequestBody UserDO userDO) throws Exception {
        if(userService.checkUser(userDO)){
            return new Result<>(ResultEnum.SUCCESS.getCode(), "登录成功", userDO);
        }
        else{
            throw new UserNotExistException(ResultEnum.FAILURE);
        }
    }

    @PostMapping("/register")
    public Result<UserDO> register(@RequestBody UserDO userDO){
        if(userService.checkUserExist(userDO)){
            return new Result<>(ResultEnum.USEREXIST.getCode(), ResultEnum.USEREXIST.getMsg(), null);
        }
        else {
            return new Result<>(ResultEnum.SUCCESS.getCode(), "注册成功", userService.addUser(userDO));
        }
    }
}
