package com.panda.study.designmodel_gp.singleton.threadlocal;/**
 * Created by My on 2020-02-27.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:47:24 2020-02-27
 * @Modified By:
 */
public class ThreadLocalSingleton {
    // ThreadLocal --> ThreadLocalMap --> Thread
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    private ThreadLocalSingleton(){}
    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }
}
