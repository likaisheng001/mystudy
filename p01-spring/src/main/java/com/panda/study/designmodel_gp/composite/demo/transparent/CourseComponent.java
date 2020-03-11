package com.panda.study.designmodel_gp.composite.demo.transparent;/**
 * Created by My on 2020-03-11.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 07:57:10 2020-03-11
 * @Modified By:
 */
public abstract class CourseComponent {
    public void addChild(CourseComponent component){
        throw new UnsupportedOperationException("不支持添加操作!");
    }

    public void removeChild(CourseComponent component){
        throw new UnsupportedOperationException("不支持删除操作!");
    }

    public String getName(CourseComponent component){
        throw new UnsupportedOperationException("不支持获取名称操作!");
    }

    public double getPrice(CourseComponent component){
        throw new UnsupportedOperationException("不支持获得价格操作!");
    }
    public void print(){
        throw new UnsupportedOperationException("不支持打印操作!");
    }
}
