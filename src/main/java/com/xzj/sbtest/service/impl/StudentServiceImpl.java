package com.xzj.sbtest.service.impl;

import com.xzj.sbtest.entity.StudentDO;
import com.xzj.sbtest.enums.ResultEnum;
import com.xzj.sbtest.exception.MsgErrorException;
import com.xzj.sbtest.mapper.StudentMapper;
import com.xzj.sbtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * StudentServiceImpl class
 *
 * @author ppx
 * @date 2018/12/09
 */
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDO> queryAll(){
        return studentMapper.selectAll();
    }

    @Override
    public StudentDO queryOne(Integer id){
        StudentDO studentDO = studentMapper.selectByPrimaryKey(id);
        Integer score = Integer.parseInt(studentDO.getScore());
        Integer age = 60;
        if(score < age){
            throw new MsgErrorException(ResultEnum.FAILED);
        }
        else {
            return studentDO;
        }
    }

    @Override
    public StudentDO insertOne(StudentDO studentDO){
        studentMapper.insert(studentDO);
        return studentDO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTwo(){
        StudentDO studentDO1 = new StudentDO();
        studentDO1.setName("111");
        studentDO1.setAge(23);
        studentDO1.setScore("60");
        studentMapper.insert(studentDO1);

        StudentDO studentDO2 = new StudentDO();
        studentDO2.setName("2222");
        studentDO2.setAge(24);
        studentDO2.setScore("65");
        studentMapper.insert(studentDO2);
    }

    @Override
    public StudentDO getOne(Integer id){
        return studentMapper.selectByPrimaryKey(id);
    }

}
