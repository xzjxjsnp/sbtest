package com.xzj.sbtest.service.impl;

import com.xzj.sbtest.entity.ThreadResultDO;
import com.xzj.sbtest.thread.ThreadDemo;
import com.xzj.sbtest.service.ThreadService;
import com.xzj.sbtest.thread.ThreadTest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ThreadServiceImpl class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Service
public class ThreadServiceImpl implements ThreadService {
    @Override
    public List<ThreadResultDO> threadTest(Integer threadNum) throws InterruptedException {
        ThreadDemo threadDemo = ThreadDemo.getInstance();
        threadDemo.setSequence((short)-1);
        threadDemo.getThreadResultDOList().clear();

        Thread[] threads = new Thread[threadNum];
        for(int i = 0; i < threadNum; ++i){
            threads[i] = new Thread(new ThreadTest(i, 10));
        }

        for(Thread ct : threads){
            ct.start();
        }

        for(Thread ct : threads){
            ct.join();
        }

        return threadDemo.getThreadResultDOList();
    }
}
