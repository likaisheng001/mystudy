package designmodel.singleton.type1;

/**
 * Created by Administrator on 2019/8/9.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode()=" + instance.hashCode() + "\ninstance2.hashCode()=" + instance2.hashCode());
    }
}

/**
 * 饿汉式：使用静态常量
 * 单例模式的约定：
 * 1.私有化构造器
 * 2.在类的内部创建对象(不同的单例模式创建对象的方式不同)
 * 2.对外暴露获取对象的静态公共方法
 */
class Singleton{
    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return instance;
    }
}
