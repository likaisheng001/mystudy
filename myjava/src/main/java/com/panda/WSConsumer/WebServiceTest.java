package com.panda.WSConsumer;


import org.junit.Test;

/**
 * Created by My on 2019/10/8.
 */
public class WebServiceTest {
    @Test
    public void testWebService(){
        //获取webservice服务器对象（这里的类名，其实是从wsdl文件中的servicename标签中进行获取的）
        WebServiceDemoService webServiceDemoService = new WebServiceDemoService();
        //获取到我们自定义的webservice的对象
        WebServiceDemo webServiceDemo = webServiceDemoService.getWebServiceDemoPort();
        //调用service服务器中的方法
        String receivedInfo = webServiceDemo.testWebService("您好，webservice 服务器");
        //打印从服务器的方法中得到的返回值，测试表示收到了服务器返回的内容
        System.out.println("服务器返回的内容是：" + receivedInfo);
    }
}
