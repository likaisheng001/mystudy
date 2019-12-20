package com.panda.spring2;

import com.panda.spring2.demo.action.MyAction;
import com.panda.spring2.framework.context.GPApplicationContext;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:37:25 2019-12-14
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        GPApplicationContext context = new GPApplicationContext("classpath:application.properties");
        try {
           //Object object =  context.getBean("myAction");
            Object object = context.getBean(MyAction.class);
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(context);
    }
}
