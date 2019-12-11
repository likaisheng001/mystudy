package com.panda.pattern.observer.demo3;/**
 * Created by My on 2019-12-11.
 */

import com.google.common.eventbus.Subscribe;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:32:42 2019-12-11
 * @Modified By:
 */
public class GuavaEvent {
    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，传入的参数是：" + str);
    }
}
