package com.panda.study.designmodel_gp.observer.mouseevent.events;/**
 * Created by My on 2020-03-24.
 */

import com.panda.study.designmodel_gp.observer.mouseevent.core.Event;
import com.panda.study.designmodel_gp.observer.mouseevent.core.EventListener;

/**
 * @Author: Likaisheng
 * @Description: 可以理解成观察者
 * @Date: Created in 15:41:30 2020-03-24
 * @Modified By:
 */
public class MouseEventListener implements EventListener {
    public void onClick(Event e){
//        Mouse mouse = (Mouse) e.getSource();
//        mouse.click();
        System.out.println("---------触发鼠标单击事件-------\n" + e);
    }
    public void onMove(Event e){
        System.out.println("-------------触发鼠标移动事件-------------------\n" + e);
    }
}
