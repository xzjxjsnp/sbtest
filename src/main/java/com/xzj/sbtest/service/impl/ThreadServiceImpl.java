package com.xzj.sbtest.service.impl;

import com.xzj.sbtest.entity.ThreadResultDO;
import com.xzj.sbtest.thread.ThreadDemo;
import com.xzj.sbtest.service.ThreadService;
import com.xzj.sbtest.thread.ThreadTest;
import org.springframework.stereotype.Service;

import java.util.List;

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

//        //设置一定间隔 确保所有子线程执行完毕后主线程再返回结果。
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return threadDemo.getThreadResultDOList();
    }
}
