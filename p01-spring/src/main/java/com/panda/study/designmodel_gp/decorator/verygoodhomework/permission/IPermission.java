package com.panda.study.designmodel_gp.decorator.verygoodhomework.permission;/**
 * Created by My on 2020-03-10.
 */

/**
 * @Author: Likaisheng
 * @Description: 权限接口，用于扩展不同权限
 * @Date: Created in 11:05:14 2020-03-10
 * @Modified By:
 */
public interface IPermission {
    /**
     * 展示权限拥有的功能导航
     * @return
     */
    String showPermNavs();
}
