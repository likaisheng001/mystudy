package com.panda.study.designmodel_gp.strategy.homework;/**
 * Created by My on 2020-03-15.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:37:20 2020-03-15
 * @Modified By:
 */
public class UserOperation {
    private String uid;
    private String operationName;

    public UserOperation(String uid, String operationName) {
        this.uid = uid;
        this.operationName = operationName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "uid='" + uid + '\'' +
                ", operationName='" + operationName + '\'' +
                '}';
    }
}
