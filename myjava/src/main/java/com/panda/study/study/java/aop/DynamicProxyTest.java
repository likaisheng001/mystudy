package com.panda.study.study.java.aop;

/**
 * Created by Administrator on 2019/6/30.
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setPassword("1234");

        //-------第一步测试
        UserService service = new UserServiceImpl();
        service.add(user);
        service.delete(3);
        service.update(3);
        service.getUserInfo(3);
        System.out.println("===============================================================");
        //-------第二步测试,加了checkSecurity()方法
//        UserService service2 = new StaticProxyUserImpl(new UserServiceImpl());
//        service2.add(user);
//        service2.delete(3);
//        service2.update(3);
//        service2.getUserInfo(3);
//        System.out.println("===============================================================");
        //-------第三步测试,加了动态代理，整个系统一份统一调用
        //该例被代理的对象是User，如果明天新增Customer、Order、Staff等实体，根据需要置换需要被代理的对象即可。
        UserService service3 = (UserService) new DymicProxyImpl().getProxyInstance(new UserServiceImpl());
        service3.add(user);
        service3.delete(3);
        service3.update(3);
        service3.getUserInfo(3);
    }
}
