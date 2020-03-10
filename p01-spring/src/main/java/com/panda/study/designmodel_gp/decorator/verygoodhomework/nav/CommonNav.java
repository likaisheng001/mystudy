package com.panda.study.designmodel_gp.decorator.verygoodhomework.nav;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description: 公共导航功能：所有权限都拥有的导航功能，原始组件
 * @Date: Created in 10:58:30 2020-03-10
 * @Modified By:
 */
public class CommonNav implements  INav {
    @Override
    public String showNavs() {
        return "问答--文章--精品课--冒泡--商城";
    }
}
