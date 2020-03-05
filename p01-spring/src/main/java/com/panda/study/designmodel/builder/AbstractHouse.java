package com.panda.study.designmodel.builder;

/**
 * Created by Administrator on 2019/7/29.
 */
public abstract class AbstractHouse {
    //打地基
    public abstract void buildBasic();
    //砌墙
    public abstract void buildwalls();
    //封顶
    public abstract void roofed();

    public void build(){
        buildBasic();
        buildwalls();
        roofed();
    }
}
