package com.panda.study.designmodel_gp.chain.auth.optimize;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.chain.auth.Member;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:47:18 2020-03-15
 * @Modified By:
 */
public abstract class Handler {
    protected Handler next;
    public void next(Handler next){
        this.next = next;
    }
    public abstract void doHandler(Member member);
}
