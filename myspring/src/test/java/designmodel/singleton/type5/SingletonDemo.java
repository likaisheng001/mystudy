package designmodel.singleton.type5;

/**
 * Created by Administrator on 2019/8/9.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println("懒汉式：同步代码块创建对象");
        System.out.println("instance.hashCode()=" + instance.hashCode() + "\ninstance2.hashCode()=" + instance2.hashCode());
    }
}
//懒汉式：同步代码块
class Singleton{
    private static Singleton instance;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
       return instance;
    }
}
