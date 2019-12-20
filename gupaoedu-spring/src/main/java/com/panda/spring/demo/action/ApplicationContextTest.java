package com.panda.spring.demo.action;/**
 * Created by My on 2019-12-02.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Likaisheng
 * @Description: 源码阅读
 * @Date: Created in 21:07:47 2019-12-02
 * @Modified By:
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
    }
}
