package com.xzj.sbtest.service;

import com.xzj.sbtest.entity.ThreadResultDO;

import java.util.List;

/**
 * ThreadService interface
 *
 * @author ppx
 * @date 2018/12/09
 */
public interface ThreadService {
    /**
     * 多线程demo测试类
     * @param threadNum 线程数目
     * @return List<ThreadResultDO>
     * @throws InterruptedException 异常
     */
    List<ThreadResultDO> threadTest(Integer threadNum) throws InterruptedException;
}
