package designmodel.singleton.type7;

/**
 * Created by Administrator on 2019/8/9.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println("懒汉式：静态内部类");
        System.out.println("instance.hashCode()=" + instance.hashCode() + "\ninstance2.hashCode()=" + instance2.hashCode());
    }
}
//使用静态内部类创建
class Singleton{
    private static volatile Singleton instance;
    private Singleton(){

    }
    static class SingletonInstance{
        private static Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
