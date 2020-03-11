package com.panda.study.designmodel_gp.composite.demo.safe;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 08:18:17 2020-03-11
 * @Modified By:
 */
public abstract class Directory {
    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();

}
