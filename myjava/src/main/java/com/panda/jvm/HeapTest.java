package com.panda.jvm;/**
 * Created by My on 2019-12-14.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:14:46 2019-12-14
 * @Modified By:
 */

public class HeapTest {
    //此段代码无法演示出OOM head space的效果
    //Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
    public static void main(String[] args) {
        List<Object> objList = new LinkedList<Object>();
        try{
            while(true){
                Thread.sleep(500);
                System.out.println("添加一个对象！");
                objList.add(new Object());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("objList.Size() = " + objList.size());
        }
    }
   /* public static void main(String[] args) {
        List<Byte[]> list = new ArrayList<>();
        int i = 0;
        try{
            while (true){
                Thread.sleep(500);
                list.add(new Byte[1024*10]);
                i++;
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }finally {
            System.out.println("次数：" + i);
        }
    }*/
}
