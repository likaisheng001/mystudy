package com.panda.study.designmodel_gp.composite.homework;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:24:57 2020-03-11
 * @Modified By:
 */
public class Test   {
    public static void main(String[] args) {
        Node root = new Node("html",null);
        Node body = new Node("body", root);
        Node text = new Node("text", body);
        Node href = new Node("href", body);
        Text t1 = new Text(text);
        t1.setContent("Hello world!");
        System.out.println(t1.xpath());
        t1.show();
        href.show();
    }
}
