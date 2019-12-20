package com.panda.pattern.delegate.simple;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:13:57 2019-12-09
 * @Modified By:
 */
public class DelegateTest {
    public static void main(String[] args) {
        new Boss().command("架构",new Leader());
    }
}
