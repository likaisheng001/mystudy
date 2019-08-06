package com.panda.study.designmodel.observer.improve;

/**
 * Created by Administrator on 2019/8/5.
 */
public class Client {
    public static void main(String[] args) {
        //创建一个WeatherData
        WeatherData weatherData = new WeatherData();
        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        //注册到weatherData
        weatherData.registerObserver(currentConditions);
        BaiduSite baiduSite = new BaiduSite();
        weatherData.registerObserver(baiduSite);
        //测试
        System.out.println("通知各个注册的观察者，看看信息");
        weatherData.setData(10f,100f,30.3f);
    }
}
