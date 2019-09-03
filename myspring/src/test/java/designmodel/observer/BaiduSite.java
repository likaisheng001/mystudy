package designmodel.observer;

/**
 * Created by Administrator on 2019/9/1.
 */
public class BaiduSite implements Observer{
    //温度、气压、湿度
    private float temperature;
    private float pressure;
    private float humidity;
    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
    public void display(){
        System.out.println("*** baidu Today mTemperature:" + temperature + "***");
        System.out.println("*** baidu Today pressure:" + pressure + "***");
        System.out.println("*** baidu Today humidity  :" + humidity + "***");
    }
}
