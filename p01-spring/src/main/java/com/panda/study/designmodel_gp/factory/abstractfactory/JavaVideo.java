package com.panda.study.designmodel_gp.factory.abstractfactory;/**
 * Created by My on 2020-03-05.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:47:27 2020-03-05
 * @Modified By:
 */
public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("录制Java视频");
    }
}
