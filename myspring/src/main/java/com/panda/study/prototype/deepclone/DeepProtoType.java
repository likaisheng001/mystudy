package com.panda.study.prototype.deepclone;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

/**
 * Created by Administrator on 2019/7/29.
 */
public class DeepProtoType implements Serializable,Cloneable{
    public String name;//String属性
    public DeepCloneableTarget deepCloneableTarget;//引用类型
    public DeepProtoType(){
        super();
    }
    //深拷贝 - 方式1 重写chone方法（引用类型需要单独处理）
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //这里完成对基本数据类型(属性)的克隆
        deep = super.clone();
        //对引用类型的属性，进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget =(DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }
    //深拷贝 - 方式2 通过对象的序列化实现（推荐）
    public Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        DeepProtoType copyObj = null;
        try{
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            //将当前这个对象以对象流的方式输出
            oos.writeObject(this);
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            copyObj = (DeepProtoType)ois.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                //此处简单处理(实际中不采用)
                oos.close();
                bos.close();
                ois.close();
                bis.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return copyObj;
    }
}
