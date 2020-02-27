package designmodel_gp.singleton;/**
 * Created by My on 2020-02-27.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:48:39 2020-02-27
 * @Modified By:
 */
public class LazySimpleSintletonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();
        System.out.println("End");
    }
}
