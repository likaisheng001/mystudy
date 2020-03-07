package com.panda.study.designmodel_gp.decorator.battercake;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:26:31 2020-03-07
 * @Modified By:
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
