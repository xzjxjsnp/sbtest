package com.xzj.sbtest.service.impl;

import com.xzj.sbtest.entity.ThreadResultDO;
import com.xzj.sbtest.thread.ThreadDemo;
import com.xzj.sbtest.service.ThreadService;
import com.xzj.sbtest.thread.ThreadTest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

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

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threadNum, threadNum, 4,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(threadNum * 2), new ThreadPoolExecutor.CallerRunsPolicy());

        Future[] futures = new Future[threadNum];
        for (int i = 0; i < threadNum; ++i) {
            //讲Runnable接口转换为Callable接口，每次提交任务的返回值为i
            futures[i] = threadPoolExecutor.submit(Executors.callable(new ThreadTest(i, 10), i));
        }

        for (int i = 0; i < threadNum; i++) {
            try {
                //System.out.println(futures[i].get()); 会一直阻塞直到结果返回，返回结果为i。

                //阻塞固定时间
                System.out.println(futures[i].get(10, TimeUnit.SECONDS));
            } catch (TimeoutException e) {
                e.printStackTrace();
                //取消超时的线程
                futures[i].cancel(true);
            } catch (InterruptedException e) {
                //do nothing
            } catch (ExecutionException e) {
                e.printStackTrace();
                e.getCause().getMessage();
            }
        }

        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS);
        return threadDemo.getThreadResultDOList();
    }
}
