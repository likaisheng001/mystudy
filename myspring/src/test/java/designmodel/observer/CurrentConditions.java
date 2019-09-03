package designmodel.observer;

//currentcondition实质上是个观察者
public class CurrentConditions implements Observer{
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
        System.out.println("*** Today mTemperature:" + temperature + "***");
        System.out.println("*** Today pressure:" + pressure + "***");
        System.out.println("*** Today humidity  :" + humidity + "***");
    }
}
