package com.panda.tmptest.demo1;/**
 * Created by My on 2019-12-12.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:21:42 2019-12-12
 * @Modified By:
 */
public class Customer {
    private String id;//客户ID
    private String customerName;//客户
    private String guideName;//导购

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }
}
