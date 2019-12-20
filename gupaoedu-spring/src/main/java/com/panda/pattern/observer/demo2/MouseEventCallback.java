package com.panda.pattern.observer.demo2;/**
 * Created by My on 2019-12-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:58:15 2019-12-11
 * @Modified By:
 */
public class MouseEventCallback {
    public void onClick(Event e){
        System.out.println("=======触发鼠标单击事件=========");
    }

    public void onDoubleClick(Event e){
        System.out.println("=======触发鼠标双击事件==========");
    }
    public void onUp(Event e){
        System.out.println("=======触发鼠标弹起事件===========");
    }
    public void onDown(Event e){
        System.out.println("=======触发鼠标按下事件===========");
    }
    public void onMove(Event e){
        System.out.println("=======触发鼠标移动事件===========");
    }
    public void onWheel(Event e){
        System.out.println("=======触发鼠标滚动事件===========");
    }
    public void onOver(Event e){
        System.out.println("=======触发鼠标悬停事件===========");
    }
    public void onBlur(Event e){
        System.out.println("=======触发鼠标失焦事件===========");
    }
    public void onFocus(Event e){
        System.out.println("=======触发鼠标获焦事件===========");
    }
}
