package com.panda.study.designmodel_gp.composite.homework;/**
 * Created by My on 2020-03-11.
 */

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:13:15 2020-03-11
 * @Modified By:
 */
public class Node extends Ele{
    private List<Ele> eles;
    private String name; // 节点的名称例如 <select>...</select> 名称就是select

    public Node(String name,Ele parentEle) {
        super(parentEle);
        this.name = name;
        eles = new ArrayList<Ele>();
    }

    public void addEle(Ele ele){
        ele.setParentEle(this);
        eles.add(ele);
    }

    public List<Ele> getEles() {
        return eles;
    }

    public void setEles(List<Ele> eles) {
        this.eles = eles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void show() {
        String url = xpath();
        System.out.println(url);
        for (int i = 0; i < eles.size(); i++) {
            for (int j = 0; j < url.length(); j++) {
                System.out.print(" ");
            }
            eles.get(i).show();
        }
    }

    @Override
    public String xpath() {
        List<String> names = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        Node n = (Node)this.getParentEle();
        while (n != null){
            names.add(n.getName());
            n = (Node)n.getParentEle();
        }

        for (int i = names.size()-1; i >= 0; i--) {
            builder.append(names.get(i)).append("/");
        }
        builder.append(this.name);
        return builder.toString();
    }
}
