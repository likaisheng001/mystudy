package com.panda.study.designmodel.proxy.dynamicproxy;

/**
 * Created by Administrator on 2019/8/1.
 */
public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("老师授课中 ... ");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
