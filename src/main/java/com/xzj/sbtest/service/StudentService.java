package com.xzj.sbtest.service;

import com.xzj.sbtest.entity.StudentDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDO> queryAll();
    StudentDO queryOne(Integer id);
    StudentDO insertOne(StudentDO studentDO);
    void insertTwo();
    StudentDO getOne(Integer id);
}
