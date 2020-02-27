package designmodel_gp.singleton;/**
 * Created by My on 2020-02-27.
 */

import com.panda.study.designmodel_gp.singleton.register.ContainerSingleton;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:13:25 2020-02-27
 * @Modified By:
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object instance = ContainerSingleton.getInstance("designmodel_gp.singleton.Pojo");
        System.out.println(instance);
    }
}
