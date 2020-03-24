package com.panda.study.designmodel_gp.visitor.general;

// 抽象元素
public interface IElement {
    void accept(IVisitor visitor);
}