package designmodel.observer;

/**
 * Created by Administrator on 2019/9/1.
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditions currentConditions = new CurrentConditions();
        weatherData.registerObserver(currentConditions);
        BaiduSite baiduSite = new BaiduSite();
        weatherData.registerObserver(baiduSite);
        System.out.println("通知各个注册的观察者，看看信息");
        weatherData.setData(10f,100f,30.3f);
    }
}
