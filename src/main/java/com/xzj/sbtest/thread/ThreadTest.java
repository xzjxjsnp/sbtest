package com.xzj.sbtest.thread;

import com.xzj.sbtest.entity.ThreadResultDO;

public class ThreadTest implements Runnable{
    private final int requestCount;
    private final String threadName;

    public ThreadTest(int id, int requestCount) {
        this.threadName = "worker-" + (id + 1);
        this.requestCount = requestCount;
    }

    @Override
    public void run() {
        int i = requestCount;
        String requestId;
        ThreadResultDO threadResultDO = ThreadResultDO.getInstance();
        while(i-- > 0){
            requestId = threadResultDO.nextId();
            try {
                processRequest(requestId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processRequest(String requestId) throws InterruptedException {
        Thread.sleep(50);
        System.out.printf("%s got requestId: %s %n", threadName, requestId);
        ThreadResultDO.getInstance().getThreadResult().add(threadName + " got requestId: " + requestId);
    }
}
