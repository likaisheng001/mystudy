package com.panda.study.designmodel_gp.decorator.battercake;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:30:01 2020-03-07
 * @Modified By:
 */
public class EggDecorator extends BatterCakeDecorator {
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
