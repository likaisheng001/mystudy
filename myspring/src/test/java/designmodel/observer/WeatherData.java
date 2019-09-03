package designmodel.observer;

import java.util.ArrayList;

//此处的weatherData类似于Object（被观察的对象）
//通过继承和subject联系起来，这样的设计显得有点不合适
public class WeatherData implements Subject{
    private float temperature;
    private float pressure;
    private float humidity;

    private ArrayList<Observer> observers;

    public WeatherData() {
        //此处不建议这样使用数组链表，这里有个扩容机制
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(temperature,pressure,humidity);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void dataChange(){
        notifyObserver();
    }

    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }
}
