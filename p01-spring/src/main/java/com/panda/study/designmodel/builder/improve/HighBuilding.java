package com.panda.study.designmodel.builder.improve;

/**
 * Created by Administrator on 2019/7/29.
 */
public class HighBuilding extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼打地基100米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙20cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼透明屋顶");
    }
}
