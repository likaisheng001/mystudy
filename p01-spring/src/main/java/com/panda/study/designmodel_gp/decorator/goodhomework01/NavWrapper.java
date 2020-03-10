package com.panda.study.designmodel_gp.decorator.goodhomework01;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:14:37 2020-03-07
 * @Modified By:
 */
public class NavWrapper implements INav {

    private INav nav;

    public NavWrapper(INav nav) {
        this.nav = nav;
    }

    @Override
    public String getNavs() {
        return nav.getNavs();
    }
}
