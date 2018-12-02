package com.xzj.sbtest.service;

import com.xzj.sbtest.dto.PwdDTO;
import com.xzj.sbtest.dto.UserDTO;
import com.xzj.sbtest.entity.UserDO;

public interface UserService {
    boolean checkUser(UserDO userDO) throws Exception;
    boolean checkUserExist(UserDO userDO);
    UserDO addUser(UserDO userDO);
    UserDO getUserInfo(String username);
    UserDO updateUserInfo(UserDTO userDTO);
    boolean changePwd(PwdDTO pwdDTO) throws Exception;
}
