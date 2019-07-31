package com.panda.study.designmodel.facade;

/**
 * Created by Administrator on 2019/7/31.
 */
public class Projector {
    private static Projector instance = new Projector();
    public static Projector getInstance(){
        return instance;
    }
    public void on(){
        System.out.println("projector on");
    }
    public void off(){
        System.out.println("projector off");
    }
    public void focus(){
        System.out.println("projector focus");
    }
}
