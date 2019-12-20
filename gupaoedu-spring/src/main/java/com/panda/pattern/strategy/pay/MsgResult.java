package com.panda.pattern.strategy.pay;/**
 * Created by My on 2019-12-09.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 21:45:23 2019-12-09
 * @Modified By:
 */
public class MsgResult {
    private int code;
    private Object data;
    private String msg;

    public MsgResult(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "支付状态：["+ code +"]," + msg + ",交易详情：" + data;
    }
}
