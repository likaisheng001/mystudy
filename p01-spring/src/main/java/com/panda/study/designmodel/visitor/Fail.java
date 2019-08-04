package com.panda.study.designmodel.visitor;

/**
 * Created by Administrator on 2019/8/4.
 */
public class Fail extends Action{
    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价该歌手失败！");
    }
    @Override
    public void getWomanResult(Woman man) {
        System.out.println("女人给的评价该歌手失败！");
    }
}
