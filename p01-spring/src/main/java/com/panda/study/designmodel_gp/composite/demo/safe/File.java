package com.panda.study.designmodel_gp.composite.demo.safe;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 08:23:59 2020-03-11
 * @Modified By:
 */
public class File extends Directory {
    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
