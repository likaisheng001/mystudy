package com.panda.study.designmodel_gp.decorator.verygoodhomework.nav;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:01:45 2020-03-10
 * @Modified By:
 */
public class QuestionNav extends AbsDecorator {

    public QuestionNav(INav nav) {
        super(nav);
    }

    @Override
    public String showNavs() {
        return nav.showNavs() + "--题库";
    }
}
