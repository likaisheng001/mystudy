package com.panda.study.designmodel_gp.decorator.goodhomework01;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:19:12 2020-03-07
 * @Modified By:
 */
public class BrilliantNavWrapper extends NavWrapper {
    public BrilliantNavWrapper(INav nav) {
        super(nav);
    }

    @Override
    public String getNavs() {
        return super.getNavs() + "  精品课";
    }
}
