package com.panda.pattern.observer.demo3;/**
 * Created by My on 2019-12-11.
 */

import com.google.common.eventbus.EventBus;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:33:48 2019-12-11
 * @Modified By:
 */
public class GuavaEventTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("Tom");
    }
}
