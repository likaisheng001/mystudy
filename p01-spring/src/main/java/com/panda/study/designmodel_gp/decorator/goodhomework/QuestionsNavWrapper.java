package com.panda.study.designmodel_gp.decorator.goodhomework;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:17:55 2020-03-07
 * @Modified By:
 */
public class QuestionsNavWrapper extends NavWrapper {
    public QuestionsNavWrapper(INav nav) {
        super(nav);
    }

    @Override
    public String getNavs() {
        return super.getNavs() + "  题库";
    }
}
