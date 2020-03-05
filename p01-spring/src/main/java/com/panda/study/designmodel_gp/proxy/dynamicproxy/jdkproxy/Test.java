package com.panda.study.designmodel_gp.proxy.dynamicproxy.jdkproxy;/**
 * Created by My on 2020-03-02.
 */

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:16:02 2020-03-02
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        JdkMeipo jdkMeipo = new JdkMeipo();
        IPerson zhangsan = jdkMeipo.getInstance(new Zhangsan());
        //IPerson zhaoliu = jdkMeipo.getInstance(new ZhaoLiu());

        //利用工具获取生成的代理类,使用jad反编译$Proxy0.class字节码文件
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\$Proxy0.class");
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null){
                        fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //zhaoliu.findLove();
        //zhaoliu.buyInsurance(); // 此处扩展优点问题！
    }
}
