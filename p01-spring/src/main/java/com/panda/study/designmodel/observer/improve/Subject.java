package com.panda.study.designmodel.observer.improve;

//接口,让WeatherData来实现
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
