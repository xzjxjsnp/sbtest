package com.xzj.sbtest.service;

import com.xzj.sbtest.entity.ThreadResultDO;

import java.util.List;

public interface ThreadService {
    List<ThreadResultDO> threadTest(Integer threadNum) throws InterruptedException;
}
