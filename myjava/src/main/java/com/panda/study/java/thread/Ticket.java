package com.panda.study.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/6/20.
 */
public class Ticket implements Callable<String>{
    private int num = 90; // 系统剩余90张票
    private Lock lock = new ReentrantLock();
    private int sellnum = 0;

    @Override
    public String call() throws Exception {
        //模拟柜台处理每个请求需要0.5秒
        Thread.sleep(500);
        lock.lock();
        try{
            if (num>0){
                num--;
                System.out.println("卖出了"+ (++sellnum) +"张票");
            }else {
                return "没有买到票";
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return "买票成功";
    }
}
