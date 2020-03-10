package com.panda.study.designmodel_gp.decorator.verygoodhomework.nav;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:00:16 2020-03-10
 * @Modified By:
 */
public abstract class AbsDecorator implements INav{
    protected INav nav;

    protected AbsDecorator(INav nav){
        this.nav = nav;
    }

    @Override
    public abstract String showNavs();
}
