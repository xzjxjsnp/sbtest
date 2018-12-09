package com.xzj.sbtest.service.impl;

import com.xzj.sbtest.dto.PwdDTO;
import com.xzj.sbtest.dto.UserDTO;
import com.xzj.sbtest.entity.UserDO;
import com.xzj.sbtest.enums.ResultEnum;
import com.xzj.sbtest.exception.MsgErrorException;
import com.xzj.sbtest.mapper.UserMapper;
import com.xzj.sbtest.service.UserService;
import com.xzj.sbtest.utils.RsaHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * UserServiceImpl class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Service
public class UserServiceImpl implements UserService {
    @Value("${key.private}")
    private String privateKey;

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean checkUser(UserDO userDO) throws Exception {
        UserDO userDO1 = getUserInfo(userDO.getUsername());
        if (userDO1 == null) {
            return false;
        } else {
            String pswDb = new String(RsaHelper.decryptByPrivateKey(Base64.decodeBase64(userDO1.getPassword()),
                    Base64.decodeBase64(privateKey)));
            String psw = new String(RsaHelper.decryptByPrivateKey(Base64.decodeBase64(userDO.getPassword()),
                    Base64.decodeBase64(privateKey)));
            if (pswDb.equals(psw)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean checkUserExist(UserDO userDO){
        Example example = new Example(UserDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", userDO.getUsername());
        if (userMapper.selectByExample(example).size() != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public UserDO addUser(UserDO userDO){
        if(userMapper.insert(userDO) > 0){
            return userDO;
        }
        else {
            throw new MsgErrorException(ResultEnum.FAILURE);
        }
    }

    @Override
    public UserDO getUserInfo(String username){
        Example example = new Example(UserDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        List<UserDO> userDOList = userMapper.selectByExample(example);
        if (userDOList.size() == 0) {
            return null;
        }
        else {
            return userDOList.get(0);
        }
    }

    @Override
    public UserDO updateUserInfo(UserDTO userDTO) {
        UserDO userDO = getUserInfo(userDTO.getUsername());
        if (userDTO.getAge() != null) {
            userDO.setAge(userDTO.getAge());
        }
        if (StringUtils.isNotBlank(userDTO.getSex())) {
            userDO.setSex(userDTO.getSex());
        }
        if (userDTO.getBirthday() != null) {
            userDO.setBirthday(userDTO.getBirthday());
        }

        Example example = new Example(UserDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", userDTO.getUsername());
        userMapper.updateByExampleSelective(userDO, example);
        return userDO;
    }

    @Override
    public boolean changePwd(PwdDTO pwdDTO) throws Exception {
        UserDO userDO = new UserDO();
        userDO.setUsername(pwdDTO.getUsername());
        userDO.setPassword(pwdDTO.getOldpwd());
        if (checkUser(userDO)) {
            UserDO userDO1 = getUserInfo(pwdDTO.getUsername());
            if (userDO1==null) {
                return false;
            }

            userDO1.setPassword(pwdDTO.getNewpwd());
            Example example = new Example(UserDO.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", pwdDTO.getUsername());
            int a = userMapper.updateByExampleSelective(userDO1, example);
            return true;
        }
        else {
            throw new MsgErrorException(ResultEnum.OLDPWDWRONG);
        }
    }
}
