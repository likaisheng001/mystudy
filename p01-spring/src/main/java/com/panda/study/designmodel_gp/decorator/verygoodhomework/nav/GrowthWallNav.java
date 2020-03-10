package com.panda.study.designmodel_gp.decorator.verygoodhomework.nav;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:02:30 2020-03-10
 * @Modified By:
 */
public class GrowthWallNav extends AbsDecorator {
    public GrowthWallNav(INav nav) {
        super(nav);
    }

    @Override
    public String showNavs() {
        return nav.showNavs() + "--成长墙";
    }
}
