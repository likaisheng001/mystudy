package designmodel.singleton.type8;

/**
 * Created by Administrator on 2019/8/9.
 */
public class SingletonDemo {
    public static void main(String[] args) {

        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println("懒汉式：枚举");
        System.out.println("instance.hashCode()=" + instance.hashCode() + "\ninstance2.hashCode()=" + instance2.hashCode());

    }
}
enum Singleton{
    INSTANCE;//属性
    public void sayOK(){
        System.out.println("------ok--------");
    }
}
