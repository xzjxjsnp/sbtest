package com.xzj.sbtest.service;

import com.xzj.sbtest.entity.StudentDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StudentService interface
 *
 * @author ppx
 * @date 2018/12/09
 */
@SuppressWarnings("ALL")
@Service
public interface StudentService {
    /**
     * 查询所有
     * @return List<StudentDO>
     */
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    List<StudentDO> queryAll();

    /**
     * 根据id查询学生信息
     * @param id 学生id
     * @return StudentDO
     */
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    StudentDO queryOne(Integer id);

    /**
     * 插入一个学生信息
     * @param studentDO 学生信息类
     * @return StudentDO
     */
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    StudentDO insertOne(StudentDO studentDO);

    /**
     * 一次插入两条记录至数据库
     */
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    void insertTwo();

    /**
     * 根据id获取一条记录
     * @param id 学生id
     * @return StudentDO
     */
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    StudentDO getOne(Integer id);
}
