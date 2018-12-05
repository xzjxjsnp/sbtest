package com.xzj.sbtest.service.impl;

import com.xzj.sbtest.entity.ThreadResultDO;
import com.xzj.sbtest.service.ThreadService;
import com.xzj.sbtest.thread.ThreadTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService {
    @Override
    public List<String> threadTest(Integer threadNum) throws InterruptedException {
        ThreadResultDO threadResultDO = ThreadResultDO.getInstance();
        threadResultDO.setSequence((short)-1);
        threadResultDO.getThreadResult().clear();

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
        return threadResultDO.getThreadResult();
    }
}
