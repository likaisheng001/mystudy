package com.panda.java.enum1;/**
 * Created by My on 2019/10/22.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:07 2019/10/22
 * @Modified By:
 */
public class EnumDemo1 {
    public static void main(String[] args) {
        for (Chenmo e:Chenmo.values()) {
            System.out.println(e);
        }
        //使用枚举作为switch语句判断条件
        Chenmo key = Chenmo.WANGER;
        switch (key){
            case WANGER:
                System.out.println("今天我送出一个CSDN大鼠标垫");
                break;
            case WANGSAN:
                System.out.println("今天我被坑了一个CSDN学院年卡");
                break;
            default:
                System.out.println("今天我一边高兴，一边失落");
                break;
        }
    }
}
enum Chenmo {
    WANGER,WANGSAN,WANGSI;
}

