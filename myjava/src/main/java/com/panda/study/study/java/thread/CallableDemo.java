package com.panda.study.study.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2019/6/21.
 */
class Thread01 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("call() come in------");
        return 200;
    }
}
public class CallableDemo{
    public static void main(String[] args) {
        //多线程的不同业务操纵的并发进行计算 -- 结果集合并
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Thread01());
        new Thread(futureTask).start();
        //A:biz others doing

        //B:
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        //Result = A + B
    }

}
