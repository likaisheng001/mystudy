package designmodel_gp.singleton;/**
 * Created by My on 2020-02-27.
 */

import com.panda.study.designmodel_gp.singleton.lazy.LazySimpleSingleton;
import com.panda.study.designmodel_gp.singleton.threadlocal.ThreadLocalSingleton;
import sun.awt.image.PixelConverter;

import static sun.awt.image.PixelConverter.Argb.instance;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 09:48:01 2020-02-27
 * @Modified By:
 */
public class ExectorThread implements Runnable{
    @Override
    public void run() {
//        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName() + ":" + instance);
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}
