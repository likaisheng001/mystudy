package designmodel.test;

/**
 * Created by Administrator on 2019/8/18.
 */
public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(IConstants.Mon);
    }
}
//接口里面可以定义变量吗？
interface IConstants{
    String Mon = "Mon";
}
enum EnumTest{
    MON,TUE,WED,THU,FRI,SAT,SUN;
}
