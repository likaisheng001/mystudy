package com.panda.study.designmodel_gp.singleton.register;/**
 * Created by My on 2020-02-27.
 */

/**
 * @Author: Likaisheng
 * @Description: 代码优雅，但不能大批量创建对象。
 * @Date: Created in 10:36:45 2020-02-27
 * @Modified By:
 */
public enum  EnumSingleton {
    INSTANCE;
    private Object data; // 给单例赋值

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
