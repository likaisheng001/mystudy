package designmodel.singleton.type2;

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
class Singleton{
    private static Singleton instance;
    private Singleton(){
    }
    static {
        instance = new Singleton();
    }
    public static Singleton getInstance(){
        return instance;
    }
}
