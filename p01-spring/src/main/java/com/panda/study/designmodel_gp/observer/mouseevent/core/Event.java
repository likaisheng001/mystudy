package com.panda.study.designmodel_gp.observer.mouseevent.core;/**
 * Created by My on 2020-03-24.
 */

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:46:27 2020-03-24
 * @Modified By:
 */
public class Event {
    // 事件源,动作是由谁发出的
    private Object source;
    // 事件触发，要通知谁(观察者)
    private EventListener target;
    // 观察者给的回应
    private Method callback;
    // 事件的名称
    private String trigger;
    // 事件的触发时间
    private Long time;

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }

    public Object getSource() {
        return source;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public Event setTarget(EventListener target) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
