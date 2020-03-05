package designmodel.proxy.dynamicproxy;

import com.panda.study.designmodel.proxy.staticproxy.TeacherDaoProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2019/8/17.
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        ITeacherDao teacherDao2 = (ITeacherDao)proxyFactory.getInstance();
        teacherDao2.teach();
    }
}
interface ITeacherDao{
    void teach();
}
class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("------ teaching --------");
    }
}
class ProxyFactory{
    Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("-----------代理开始----------");
                        Object retValue = method.invoke(target, args);
                        System.out.println("-------------代理结束---------------");
                        return retValue;
                    }
                });
    }
}

