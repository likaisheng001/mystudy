package com.panda.study.designmodel.observer.improve;

import java.util.ArrayList;

/**
 * 该类是核心
 * 1.包含最新的天气情况信息
 * 2.含有 观察者集合 使用ArrayList管理
 * 3.当数据有更新时，就主动的调用 ArrayList，通知所有的(接入方)就看到最新的信息
 */
public class WeatherData implements Subject{
    private float temperatrue;
    private float pressure;
    private float humidity;
    //观察者集合
    private ArrayList<Observer> observers;
    private CurrentConditions currentConditions;
    public WeatherData() {
        observers = new ArrayList<Observer>();
    }
    public float getTemperature() {
        return temperatrue;
    }
    public float getPressure() {
            return pressure;
    }
    public float getHumidity() {
            return humidity;
    }
    public void dataChange() {
        notifyObserver();
    }
    //当数据有更新时，就调用setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperatrue = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange,将最新的信息推送给接入方
        dataChange();
    }

    //注册一个观察者
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    //移除一个观察者
    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }
    //遍历所有的观察者，并通知
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperatrue,this.pressure,this.humidity);
        }
    }
}