package com.panda.study.designmodel.template.improve;

/**
 * Created by Administrator on 2019/8/2.
 */
public class PureSoyaMilk extends SoyaMilk{
    @Override
    void addCondiments() {
        //空实现
    }

    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
