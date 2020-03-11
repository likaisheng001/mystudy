package com.panda.study.designmodel_gp.composite.homework;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:12:54 2020-03-11
 * @Modified By:
 */
public abstract class Ele {
    private Ele parentEle; // 父元素
    abstract void show();
    public abstract String xpath();

    public Ele(Ele parentEle) {
        this.parentEle = parentEle;
    }

    public Ele getParentEle() {
        return parentEle;
    }

    public void setParentEle(Ele parentEle) {
        this.parentEle = parentEle;
    }
}
