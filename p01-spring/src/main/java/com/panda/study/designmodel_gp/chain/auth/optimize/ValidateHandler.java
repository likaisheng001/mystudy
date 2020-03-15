package com.panda.study.designmodel_gp.chain.auth.optimize;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.chain.auth.Member;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:48:57 2020-03-15
 * @Modified By:
 */
public class ValidateHandler extends Handler {

    @Override
    public void doHandler(Member member) {
        if (StringUtils.isEmpty(member.getLoginName()) ||
            StringUtils.isEmpty(member.getLoginPass())){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");
        next.doHandler(member);
    }
}
