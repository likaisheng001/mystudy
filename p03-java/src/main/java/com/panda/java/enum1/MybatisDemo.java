package com.panda.java.enum1;/**
 * Created by My on 2019/10/22.
 */

import java.util.HashMap;

/**
 * @Author: Likaisheng
 * @Description: 使用枚举配合数据库交互
 * @Date: Created in 17:30 2019/10/22
 * @Modified By:
 */
public class MybatisDemo {
    //'check_type' int(1) default null comment '检查类型(1:未通过、2：通过)'
}
enum CheckType{
    NO_PASS(0,"未通过"),PASS(1,"通过");
    private int key;
    private String text;

    private CheckType(int key, String text) {
        this.key = key;
        this.text = text;
    }

    public int getKey() {
        return key;
    }

    public String getText() {
        return text;
    }
    private static HashMap<Integer,CheckType> map = new HashMap<Integer,CheckType>();
    static{
        for (CheckType d : CheckType.values()) {
            map.put(d.key,d);
        }
    }
    public static CheckType parse(Integer index){
        if (map.containsKey(index)){
            return map.get(index);
        }
        return null;
    }
}
