package com.panda.jvm;/**
 * Created by My on 2019-12-14.
 */

import com.panda.jvm.utils.MetaspaceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 11:42:54 2019-12-14
 * @Modified By:
 */
public class MethodAreaTest {
    public static void main(String[] args) throws InterruptedException {
        List<Class<?>> list = new ArrayList<Class<?>>();
        while (true){
            list.addAll(MetaspaceUtil.createClasses());
            Thread.sleep(5);
        }
    }
}
