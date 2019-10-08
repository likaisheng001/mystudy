package WSConsumer;


import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用QName调用WebService服务
 */
public class WebServiceQNameTest {
    @Test
    public void test() throws MalformedURLException {
        //创建一个连接（地址对应的就是webservice服务器中的地址）
        URL wsdlDocumentLocation = new URL("http://localhost:9090/WebServiceDemo?wsdl");
        //这个参数，主要是根据我们设定的webService的接口来进行的
        QName serviceName = new QName("http://externalService.app.panda.com/","WebServiceDemoService");
        Service ws = Service.create(wsdlDocumentLocation , serviceName );
        //获取到调用的对象内容
        WebServiceDemo port = ws.getPort(WebServiceDemo.class);
        //方法的调用
        String result = port.testWebService("my name is scw");
        System.out.println(result);
    }
}
