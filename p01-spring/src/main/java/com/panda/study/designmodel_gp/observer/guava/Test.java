package com.panda.study.designmodel_gp.observer.guava;/**
 * Created by My on 2020-03-24.
 */

import com.google.common.eventbus.EventBus;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:20:12 2020-03-24
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        PojoEvent pojoEvent = new PojoEvent();
        VoEvent voEvent = new VoEvent();
        eventBus.register(pojoEvent);
        eventBus.register(voEvent);

        eventBus.post(new Vo("Tom"));
    }
}
