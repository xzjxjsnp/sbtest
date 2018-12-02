package com.xzj.sbtest.service;

import com.xzj.sbtest.entity.StudentDO;
import com.xzj.sbtest.mapper.StudentMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void getOne() {
        StudentDO studentDO =studentMapper.selectByPrimaryKey(5);
        Assert.assertEquals("89",studentDO.getScore());
    }
}