package com.xzj.sbtest.service;

import com.xzj.sbtest.dto.PwdDTO;
import com.xzj.sbtest.dto.UserDTO;
import com.xzj.sbtest.entity.UserDO;

/**
 * UserService interface
 *
 * @author ppx
 * @date 2018/12/09
 */
public interface UserService {
    /**
     * 检查用户名和密码是否与数据库中匹配
     *
     * @param userDO 用户DO
     * @return boolean
     * @throws Exception 异常
     */
    boolean checkUser(UserDO userDO) throws Exception;

    /**
     * 检查用户是否存在
     *
     * @param userDO 用户DO
     * @return boolean
     */
    boolean checkUserExist(UserDO userDO);

    /**
     * 添加新用户
     *
     * @param userDO 用户DO
     * @return UserDO
     */
    UserDO addUser(UserDO userDO);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return UserDO
     */
    UserDO getUserInfo(String username);

    /**
     * 更新用户信息
     *
     * @param userDTO 用户DTO
     * @return UserDO
     */
    UserDO updateUserInfo(UserDTO userDTO);

    /**
     * 更改密码
     *
     * @param pwdDTO 更改密码DTO
     * @return boolean
     * @throws Exception 异常
     */
    boolean changePwd(PwdDTO pwdDTO) throws Exception;
}
