package com.panda.study.java.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2019/6/30.
 */
public class DymicProxyImpl implements InvocationHandler{
    private Object targetObject;

    public Object getProxyInstance(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        checkSecurity();
        return method.invoke(targetObject,args);
    }
    //新增方法，需要满足的业务新需求
    private void checkSecurity(){
        System.out.println("安全检查----动态代理实现---");
    }
}
