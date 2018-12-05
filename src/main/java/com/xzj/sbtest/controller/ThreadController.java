package com.xzj.sbtest.controller;

import com.xzj.sbtest.enums.ResultEnum;
import com.xzj.sbtest.service.impl.ThreadServiceImpl;
import com.xzj.sbtest.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThreadController {
    @Autowired
    ThreadServiceImpl threadService;

    @RequestMapping("/threadTest/{threadNum}")
    public Result<List<String>> threadTest(@PathVariable("threadNum") Integer threadNum) throws InterruptedException {
        return new Result<>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(), threadService.threadTest(threadNum));
    }
}
