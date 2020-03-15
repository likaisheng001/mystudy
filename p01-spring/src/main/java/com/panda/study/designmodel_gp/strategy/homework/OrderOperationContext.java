package com.panda.study.designmodel_gp.strategy.homework;/**
 * Created by My on 2020-03-15.
 */

import com.panda.study.designmodel_gp.decorator.goodhomework01.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:23:39 2020-03-15
 * @Modified By:
 */
public class OrderOperationContext {
    private static Map<String,IOrderOperation> userOperations = new HashMap<String, IOrderOperation>();
    private static IOrderOperation DEFAULT_OPERATION;

    static {
        userOperations.put(OrderOperation.EXTEND_THE_TIME_OF_RECEIPT,new ExtendTheTimeOfReceipt());
        userOperations.put(OrderOperation.CHECK_THE_LOGISTICS,new CheckTheLogistics());
        userOperations.put(OrderOperation.CONFIRM_RECEIPT,new ConfirmReceipt());
        userOperations.put(OrderOperation.SEE_ORDER,new SeeOrder());
        DEFAULT_OPERATION = new EmptyOperation();
    }

    private OrderOperationContext(){}

    public static IOrderOperation getConcreteOrderStrategy(UserOperation operation){
        IOrderOperation orderOperation = userOperations.get(operation.getOperationName());
        return orderOperation == null ? DEFAULT_OPERATION : orderOperation;
    }

    private interface OrderOperation{
        String CONFIRM_RECEIPT = "确认收货";
        String EXTEND_THE_TIME_OF_RECEIPT = "延长收货";
        String CHECK_THE_LOGISTICS = "查看物流";
        String SEE_ORDER = "查看订单";
    }
}
