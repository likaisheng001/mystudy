package com.panda.study.designmodel_gp.factory.abstractfactory;/**
 * Created by My on 2020-03-05.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:48:27 2020-03-05
 * @Modified By:
 */
public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写Python笔记");
    }
}
