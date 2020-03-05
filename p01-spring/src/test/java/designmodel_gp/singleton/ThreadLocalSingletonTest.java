package designmodel_gp.singleton;/**
 * Created by My on 2020-02-27.
 */

import com.panda.study.designmodel_gp.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:50:30 2020-02-27
 * @Modified By:
 */
public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();
        System.out.println("End");

    }
}
