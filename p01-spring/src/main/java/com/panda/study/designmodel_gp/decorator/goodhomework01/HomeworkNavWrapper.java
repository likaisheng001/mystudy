package com.panda.study.designmodel_gp.decorator.goodhomework01;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:16:51 2020-03-07
 * @Modified By:
 */
public class HomeworkNavWrapper extends NavWrapper {
    public HomeworkNavWrapper(INav nav) {
        super(nav);
    }

    @Override
    public String getNavs() {
        return super.getNavs() + "  作业";
    }
}
