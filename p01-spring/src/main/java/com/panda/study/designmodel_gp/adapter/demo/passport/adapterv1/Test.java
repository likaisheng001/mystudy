package com.panda.study.designmodel_gp.adapter.demo.passport.adapterv1;/**
 * Created by My on 2020-03-11.
 */

import com.panda.study.designmodel_gp.adapter.demo.passport.adapterv1.PassportForThirdAdapter;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:07:30 2020-03-11
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();
        adapter.login("tom","123456");
        adapter.loginForQQ("sajdakacdgaadgadaf");
        adapter.loginForWechat("dasvewagdfg");
    }
}
