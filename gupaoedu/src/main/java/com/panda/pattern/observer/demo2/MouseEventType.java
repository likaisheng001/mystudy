package com.panda.pattern.observer.demo2;/**
 * Created by My on 2019-12-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:41:57 2019-12-11
 * @Modified By:
 */
public interface MouseEventType {
    //单击
    String ON_CLICK = "click";
    //双击
    String ON_DOUBLE_CLICK = "doubleClick";
    //弹起
    String ON_UP = "up";
    //按下
    String ON_DOWN = "down";
    //移动
    String ON_MOVE = "move";
    //滚动
    String ON_WHEEL = "wheel";
    //悬停
    String ON_OVER = "over";
    //失焦
    String ON_BLUR = "blur";
    //获焦
    String ON_FOCUS = "focus";
}
