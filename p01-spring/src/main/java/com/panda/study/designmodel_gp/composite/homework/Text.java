package com.panda.study.designmodel_gp.composite.homework;/**
 * Created by My on 2020-03-11.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 10:17:47 2020-03-11
 * @Modified By:
 */
public class Text extends Ele {
    private String content;

    @Override
    void show() {
        System.out.println(content);
    }

    @Override
    public String xpath() {
        List<String> names = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        Node n = (Node)this.getParentEle();
        while (n != null){
            names.add(n.getName());
            n = (Node) n.getParentEle();
        }

        for (int i = names.size()-1; i >= 0; i--) {
            builder.append(names.get(i)).append("/");
        }
        builder.append("文本");
        return builder.toString();
    }

    public Text(Ele parentEle) {
        super(parentEle);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
