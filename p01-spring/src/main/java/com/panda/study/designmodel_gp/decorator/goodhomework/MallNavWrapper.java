package com.panda.study.designmodel_gp.decorator.goodhomework;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:20:30 2020-03-07
 * @Modified By:
 */
public class MallNavWrapper extends NavWrapper {
    public MallNavWrapper(INav nav) {
        super(nav);
    }

    @Override
    public String getNavs() {
        return super.getNavs() + "  商城";
    }
}
