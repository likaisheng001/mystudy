package com.panda.study.designmodel_gp.builder.sql;/**
 * Created by My on 2020-03-01.
 */

/**
 * @Author: Likaisheng
 * @Description: sql排序组件
 * @Date: Created in 11:28:38 2020-03-01
 * @Modified By:
 */
public class Order {
    private boolean ascending;
    private String propertyName;

    @Override
    public String toString() {
        return propertyName + " " + (ascending ? "asc" : "desc");
    }

    public Order(String propertyName, boolean ascending) {
        this.ascending = ascending;
        this.propertyName = propertyName;
    }


    /**
     * Ascending order
     * @param propertyName
     * @return
     */
    public static Order asc(String propertyName){
        return new Order(propertyName, true);
    }

    /**
     * Descending order
     * @param propertyName
     * @return
     */
    public static Order desc(String propertyName){
        return new Order(propertyName,false);
    }
}
