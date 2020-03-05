package designmodel.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/8/17.
 */
public class CglibproxyDemo {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        TeacherDao instance = (TeacherDao)proxyFactory.getInstance();
        instance.teach();

    }
}
class ProxyFactory implements MethodInterceptor{
    Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("------------cglib start-------------");
        Object retValue = methodProxy.invokeSuper(o, objects);
        System.out.println("--------------cglib end-------------------");
        return retValue;
    }
}
class TeacherDao{
    public void teach(){
        System.out.println("------teaching------");
    }
}

