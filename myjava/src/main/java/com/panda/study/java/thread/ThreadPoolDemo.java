package com.panda.study.java.thread;

import java.util.concurrent.*;

/**
 * 阿里强制：1.线程资源只能通过线程池来获取，不允许在项目中显示创建；2.线程是只能用ThreadPoolExecutor来创建
 */
public class ThreadPoolDemo {
    /**
     * 使用多线程模拟抢票：有100个人来网站同时买票，系统剩余90张票
     * @param args
     */
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<String>(new Ticket());
        BlockingQueue<Runnable> bufferQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5,10,1000, TimeUnit.MILLISECONDS,bufferQueue);
        int n = 1;
        while (n<=100){
            System.out.println("第"+n+"个人来到窗口");
            threadPool.execute(futureTask);
            System.out.println("第"+n+"个人的请求开始处理");
            try {
                System.out.println("第"+n+"个人买票结果:" + futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            n++;
        }
    }
}
