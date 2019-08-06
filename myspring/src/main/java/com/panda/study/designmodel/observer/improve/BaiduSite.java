package com.panda.study.designmodel.observer.improve;

/**
 * Created by Administrator on 2019/8/5.
 */
public class BaiduSite implements Observer{
    //温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;
    //更新天气情况，是由WeatherData来调用，我使用推送模式
    public void update(float temperature,float pressure,float humidity){
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }
    //显示
    public void display(){
        System.out.println("=====Baidu=========");
        System.out.println("***Baidu Today mTemperature: "+temperature+"***");
        System.out.println("***Baidu Today mPressure: "+pressure+"***");
        System.out.println("***Baidu Today mHumidity: "+humidity+"***");
    }
}
