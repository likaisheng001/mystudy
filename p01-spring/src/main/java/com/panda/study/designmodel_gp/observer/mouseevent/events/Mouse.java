package com.panda.study.designmodel_gp.observer.mouseevent.events;/**
 * Created by My on 2020-03-24.
 */


import com.panda.study.designmodel_gp.observer.mouseevent.core.EventContext;

/**
 * @Author: Likaisheng
 * @Description: 具体的被观察者
 * @Date: Created in 15:41:04 2020-03-24
 * @Modified By:
 */
public class Mouse extends EventContext {
    public void click(){
        System.out.println("调用单击方法");
        this.trigger(MouseEventType.ON_CLICK);
    }
    public void move(){
        System.out.println("调用移动方法");
        this.trigger(MouseEventType.ON_MOVE);
    }
}
