package com.xzj.sbtest;

import javax.tools.Tool;

public class VisibilityTest {
    public static void main(String[] args) throws InterruptedException {
        TimeConsumingTask timeConsumingTask = new TimeConsumingTask();
        Thread thread = new Thread(timeConsumingTask);
        thread.start();

        Thread.sleep(10000);
        timeConsumingTask.cancel();
    }

    static class TimeConsumingTask implements Runnable {
        private boolean toCancel = false;

        @Override
        public void run() {
            while(!toCancel){
                try {
                    if(doExecute()){
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(toCancel){
                System.out.println("Task was canceled.");
            } else {
                System.out.println("Task done");
            }
        }

        private boolean doExecute() throws InterruptedException {
            boolean isDone = false;
            System.out.println("executing...");

            Thread.sleep(50);
            return isDone;
        }

        public void cancel(){
            toCancel = true;
            System.out.println(this+" canceled.");
        }
    }
}
