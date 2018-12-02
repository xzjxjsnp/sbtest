package com.xzj.sbtest.controller;

import com.xzj.sbtest.dto.PwdDTO;
import com.xzj.sbtest.dto.UserDTO;
import com.xzj.sbtest.entity.UserDO;
import com.xzj.sbtest.enums.ResultEnum;
import com.xzj.sbtest.exception.MsgErrorException;
import com.xzj.sbtest.exception.UserNotExistException;
import com.xzj.sbtest.service.UserService;
import com.xzj.sbtest.service.impl.UserServiceImpl;
import com.xzj.sbtest.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/getUserInfo/{username}")
    public Result<UserDO> getUserInfo(@PathVariable("username") String username){
        UserDO userDO = new UserDO();
        userDO.setUsername(username);
        if(!userService.checkUserExist(userDO)){
            throw new UserNotExistException(ResultEnum.USERNOTEXIST);
        }
        else {
            return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), userService.getUserInfo(username));
        }
    }

    @PostMapping(value = "/updateUserInfo")
    public Result<UserDO> updateUserInfo(@RequestBody UserDTO userDTO){
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), userService.updateUserInfo(userDTO));
    }

    @PostMapping(value = "/changePwd")
    public Result<UserDO> changePwd(@RequestBody PwdDTO pwdDTO) throws Exception {
        if (userService.changePwd(pwdDTO)) {
            return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), null);
        }
        else {
            throw new MsgErrorException(ResultEnum.PWDCHANGEFAILED);
        }
    }
}
