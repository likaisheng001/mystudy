package com.panda.study.designmodel_gp.observer.guava;/**
 * Created by My on 2020-03-24.
 */

import com.google.common.eventbus.Subscribe;

/**
 * @Author: Likaisheng
 * @Description: 观察者 观察的是消息总线
 * @Date: Created in 15:18:33 2020-03-24
 * @Modified By:
 */
public class VoEvent {

//    @Subscribe
//    public void observer(Object arg){
//        if (arg instanceof Vo) {
//            System.out.println("执行VoEvent方法，传参为: " + arg);
//        }
//    }


    @Subscribe
    public void observer(Vo arg){
//        if (arg instanceof Vo) {
            System.out.println("执行VoEvent方法，传参为: " + arg);
//        }
    }
}
