package com.panda.app.externalService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 四大远程调用：RPC、HTTP、RMI、Web Service
 * 此处仅演示Web Service  -- Web Service已经是java SE里面自带的内容；
 */
@WebService
public class WebServiceDemo {
    /**
     * 定义webservice服务器中的方法
     * @param content
     * @return
     */
    public String testWebService(String content){
        System.out.println("我收到了你发的信息：" + content);
        return "服务器：我转发信息给你";
    }

    public static void main(String[] args){
        //定义自己的webservice服务器发布的地址
        String address = "http://localhost:9090/WebServiceDemo"; //这个9090端口随便定义，只要不冲突即可
        //通过该方法进行发布
        Endpoint.publish(address, new WebServiceDemo());
        //打印一句话，表示一下服务器进行了开启
        System.out.println("my webservcie starting");
    }
}
