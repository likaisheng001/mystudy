package designmodel.singleton.type4;

/**
 * Created by Administrator on 2019/8/9.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstrance();
        Singleton instance2 = Singleton.getInstrance();
        System.out.println(instance == instance2);
        System.out.println("懒汉式：同步方法创建对象");
        System.out.println("instance.hashCode()=" + instance.hashCode() + "\ninstance2.hashCode()=" + instance2.hashCode());
    }
}
//懒汉式：同步方法创建对象
class Singleton{
    private static Singleton instrance;
    private Singleton(){

    }
    public synchronized static Singleton getInstrance(){
        if (instrance == null){
            instrance = new Singleton();
        }
        return instrance;
    }
}