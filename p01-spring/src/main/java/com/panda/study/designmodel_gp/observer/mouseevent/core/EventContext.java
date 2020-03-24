package com.panda.study.designmodel_gp.observer.mouseevent.core;/**
 * Created by My on 2020-03-24.
 */

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description: 被观察者抽象
 * @Date: Created in 15:40:53 2020-03-24
 * @Modified By:
 */
public class EventContext {
    protected Map<String,Event> events = new HashMap<String,Event>();

    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            if (event.getCallback() != null){
                // 用反射调用回调函数
                event.getCallback().invoke(event.getTarget(),event);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addLisenter(String eventType, EventListener target, Method callback){
        events.put(eventType,new Event(target,callback));
    }

    public void addLisenter(String eventType, EventListener target){
        try{
            this.addLisenter(eventType,target,target.getClass().getMethod("on" + toUpperFirstCase(eventType),Event.class));
        }catch (Exception e){
            // e.printStackTrace();
            return;
        }
    }

    private String toUpperFirstCase(String eventType) {
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    protected void trigger(String trigger){
        if (!this.events.containsKey(trigger)){
            return;
        }
        trigger(this.events.get(trigger).setTrigger(trigger));
    }
}
