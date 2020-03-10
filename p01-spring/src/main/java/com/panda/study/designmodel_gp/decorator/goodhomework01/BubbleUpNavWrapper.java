package com.panda.study.designmodel_gp.decorator.goodhomework01;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:19:50 2020-03-07
 * @Modified By:
 */
public class BubbleUpNavWrapper extends NavWrapper {
    public BubbleUpNavWrapper(INav nav) {
        super(nav);
    }

    @Override
    public String getNavs() {
        return super.getNavs() + "  冒泡";
    }
}
