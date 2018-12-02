package com.xzj.sbtest.controller;

import com.xzj.sbtest.service.StudentService;
import com.xzj.sbtest.utils.Result;
import com.xzj.sbtest.entity.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("queryAll")
    public Result<List<StudentDO>> queryAll(){
        return new Result<>(0,"成功",studentService.queryAll());
    }

    @GetMapping("queryOne/{id}")
    public Result<StudentDO> queryOne(@PathVariable("id") Integer id){
        return new Result<>(0,"成功", studentService.queryOne(id));
    }

    @PostMapping("insert")
    public Result<StudentDO> insertOne(@RequestBody @Validated StudentDO studentDO, BindingResult result){
        if(result.hasErrors()){
            return new Result<>(1, result.getFieldError().getDefaultMessage(),null);
        }
        return new Result<>(0,"成功", studentService.insertOne(studentDO));
    }
//
//    @PostMapping("insert")
//    public StudentDO insertOne(@RequestParam("name") String name, @RequestParam("age") Integer age) {
//        StudentDO studentDO = new StudentDO();
//        studentDO.setName(name);
//        studentDO.setAge(age);
//        return studentService.insertOne(studentDO);
//    }

//    @GetMapping("insert")
//    public StudentDO insertOne(@RequestParam("name") String name, @RequestParam("age") Integer age) {
//        StudentDO studentDO = new StudentDO();
//        studentDO.setName(name);
//        studentDO.setAge(age);
//        return studentService.insertOne(studentDO);
//    }

    @PostMapping("inserttwo")
    public void insertTwo(){
        studentService.insertTwo();
    }
}
