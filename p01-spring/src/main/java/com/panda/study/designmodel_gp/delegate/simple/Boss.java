package com.panda.study.designmodel_gp.delegate.simple;/**
 * Created by My on 2020-03-26.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:29:27 2020-03-26
 * @Modified By:
 */
public class Boss {
    public void command(String task,Leader leader){
        leader.doing(task);
    }
}
