package com.panda.study.designmodel.builder;

/**
 * Created by Administrator on 2019/7/29.
 */
public class CommonHouse extends AbstractHouse{
    @Override
    public void buildBasic() {
        System.out.println("普通房子打地基");
    }

    @Override
    public void buildwalls() {
        System.out.println("普通房子砌墙");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶");
    }
}
