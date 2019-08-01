package com.panda.study.designmodel.flyweight;

/**
 * Created by Administrator on 2019/8/1.
 */
public class Client {
    public static void main(String[] args) {
        //创建一个工厂类
        WebSiteFactory factory = new WebSiteFactory();
        //客户要一个以新闻形式发布的网站
        WebSite webSite = factory.getWebSiteCatagory("新闻");
        webSite.use(new User("Vulcan"));
        //客户要一个以博客形式发布的网站
        WebSite webSite2 = factory.getWebSiteCatagory("博客");
        webSite2.use(new User("tom"));
        //客户要一个以博客形式发布的网站
        WebSite webSite3 = factory.getWebSiteCatagory("博客");
        webSite3.use(new User("jack"));
        //客户要一个以博客形式发布的网站
        WebSite webSite4 = factory.getWebSiteCatagory("博客");
        webSite4.use(new User("smith"));
        System.out.println("网站的分类共="+factory.getWebSiteCount());
    }
}
