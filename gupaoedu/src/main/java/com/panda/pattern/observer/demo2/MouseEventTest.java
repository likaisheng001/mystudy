package com.panda.pattern.observer.demo2;/**
 * Created by My on 2019-12-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:03:14 2019-12-11
 * @Modified By:
 */
public class MouseEventTest {
    public static void main(String[] args) {
        try{
            MouseEventCallback callback = new MouseEventCallback();
            //注册事件
            Mouse mouse = new Mouse();
            mouse.addListener(MouseEventType.ON_CLICK,callback);
            mouse.addListener(MouseEventType.ON_MOVE,callback);
            mouse.addListener(MouseEventType.ON_WHEEL,callback);
            mouse.addListener(MouseEventType.ON_OVER,callback);
            //调用方法
            mouse.click();
            //失焦事件
            mouse.blur();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
