package com.panda.study.designmodel_gp.facade.points;/**
 * Created by My on 2020-03-07.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:18:57 2020-03-07
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        FacadeService facadeService = new FacadeService();
        GiftInfo giftInfo = new GiftInfo("Spring 5编程思想");
        facadeService.exchange(giftInfo);
    }
}
