package com.panda.study.designmodel_gp.decorator.battercake;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:27:40 2020-03-07
 * @Modified By:
 */
public class BatterCakeDecorator extends Battercake {
    private Battercake battercake;

    public BatterCakeDecorator(Battercake battercake){
        this.battercake = battercake;
    }

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
