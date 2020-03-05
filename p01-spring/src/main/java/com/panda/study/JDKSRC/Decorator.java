package com.panda.study.JDKSRC;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * Created by Administrator on 2019/7/30.
 */
public class Decorator {
    public static void main(String[] args) throws Exception{
        //说明
        //1.InputStream是抽象类，类似我们前面讲的Drink
        //2.FileInputStream 是 InputStream 子类，类似我们前面的DeCaf,LongBlack
        //3.FilterInputStream 是 InputStream 子类，类似我们前面的Decorator修饰者
        //4.DataInputStream 是 FilterInputStream 子类，具体的修饰者，类似前面的Milk,Soy等
        //5.FilterInputStream类有protected volatile InputStream in;即含被装饰者
        //6.分析得出在jdk的io体系中，就是使用装饰者模式
        DataInputStream dis = new DataInputStream(new FileInputStream("d:\\abc.txt"));
        System.out.println(dis.read());
        dis.close();
    }
}
