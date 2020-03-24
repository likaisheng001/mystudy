package com.panda.study.designmodel_gp.observer.mouseevent;/**
 * Created by My on 2020-03-24.
 */

import com.panda.study.designmodel_gp.observer.mouseevent.events.Mouse;
import com.panda.study.designmodel_gp.observer.mouseevent.events.MouseEventListener;
import com.panda.study.designmodel_gp.observer.mouseevent.events.MouseEventType;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:08:36 2020-03-24
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        // 观察者
        MouseEventListener listener = new MouseEventListener();
        // 被观察者
        Mouse mouse = new Mouse();
        mouse.addLisenter(MouseEventType.ON_CLICK,listener);
        mouse.addLisenter(MouseEventType.ON_MOVE,listener);

        mouse.click();
        mouse.move();
    }
}
