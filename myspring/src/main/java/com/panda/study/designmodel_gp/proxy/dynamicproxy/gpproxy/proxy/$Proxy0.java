package com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.proxy;
import com.panda.study.designmodel_gp.proxy.dynamicproxy.jdkproxy.IPerson;
import java.lang.reflect.*;
public final class $Proxy0 implements com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.client.IPerson{
    GPInvocationHandler h;
    public $Proxy0(GPInvocationHandler h){
        this.h = h;
    }
    public void findLove(){
        try{
            Method m = com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.client.IPerson.class.getMethod("findLove",new Class[]{});
            this.h.invoke(this, m, new Object[]{});
            return;}
        catch(Error _ex) { }
        catch(Throwable throwable)
        {
            throw new UndeclaredThrowableException(throwable);
        }
    }
    public void sayHello(java.lang.String a1){
        try{
            Method m = com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.client.IPerson.class.getMethod("sayHello",new Class[]{java.lang.String.class});
            this.h.invoke(this, m, new Object[]{a1});
            return;}
        catch(Error _ex) { }
        catch(Throwable throwable)
        {
            throw new UndeclaredThrowableException(throwable);
        }
    }
    public void buyInsurance(){
        try{
            Method m = com.panda.study.designmodel_gp.proxy.dynamicproxy.gpproxy.client.IPerson.class.getMethod("buyInsurance",new Class[]{});
            this.h.invoke(this, m, new Object[]{});
            return;}
        catch(Error _ex) { }
        catch(Throwable throwable)
        {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}