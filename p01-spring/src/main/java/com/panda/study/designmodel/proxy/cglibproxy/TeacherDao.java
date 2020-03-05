package com.panda.study.designmodel.proxy.cglibproxy;

/**
 * Created by Administrator on 2019/8/1.
 */
public class TeacherDao {
    public String teach(){
        System.out.println("老师授课中 ，我是cglib代理，不需要实现接口");
        return "hello";
    }
}
