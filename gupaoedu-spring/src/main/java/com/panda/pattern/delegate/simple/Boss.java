package com.panda.pattern.delegate.simple;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:47:47 2019-12-09
 * @Modified By:
 */
public class Boss {
    public void command(String command,Leader leader){
        leader.doing(command);
    }
}
