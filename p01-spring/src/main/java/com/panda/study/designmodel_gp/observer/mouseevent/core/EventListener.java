package com.panda.study.designmodel_gp.observer.mouseevent.core;/**
 * Created by My on 2020-03-24.
 */

import com.panda.study.designmodel_gp.observer.mouseevent.core.Event;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:31:37 2020-03-24
 * @Modified By:
 */
public interface EventListener {
    void onClick(Event e);
    void onMove(Event e);
}
