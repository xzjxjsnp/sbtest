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
        ThreadDemo threadDemo = ThreadDemo.getInstance();
        while(i-- > 0){
            requestId = threadDemo.nextId();
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
        ThreadResultDO threadResultDO = new ThreadResultDO();
        threadResultDO.setThreadName(threadName);
        threadResultDO.setThreadPrefix(requestId.split("-")[0]);
        threadResultDO.setThreadTimestamp(requestId.split("-")[1]);
        threadResultDO.setThreadCode(requestId.split("-")[2]);
        ThreadDemo.getInstance().getThreadResultDOList().add(threadResultDO);
    }
}
