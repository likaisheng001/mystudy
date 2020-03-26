package com.panda.study.designmodel_gp.delegate.simple;/**
 * Created by My on 2020-03-26.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:33:06 2020-03-26
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        new Boss().command("海报图",new Leader());
        new Boss().command("卖手机",new Leader());
    }
}
