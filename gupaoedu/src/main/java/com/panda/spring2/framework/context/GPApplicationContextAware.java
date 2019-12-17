package com.panda.spring2.framework.context;/**
 * Created by My on 2019-12-10.
 */

/**
 * @Author: Likaisheng
 * @Description: 通过解耦的方式获得IOC容器的顶层设计
 * 后面将通过一个监听器去扫描所有的类，只要实现了此接口，
 * 将自动调用setApplicationContext()方法，从而将IOC容器注入到目标类中
 * @Date: Created in 21:06:41 2019-12-10
 * @Modified By:
 */
public interface GPApplicationContextAware {
    void setApplicationContext(GPApplicationContext applicationContext);
}
