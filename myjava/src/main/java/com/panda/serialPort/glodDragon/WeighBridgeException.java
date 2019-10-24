package com.panda.serialPort.glodDragon;/**
 * Created by My on 2019/10/23.
 */

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:05 2019/10/23
 * @Modified By:
 */
public class WeighBridgeException extends RuntimeException{
    public WeighBridgeException() {
        super();
    }

    public WeighBridgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeighBridgeException(Throwable cause) {
        super(cause);
    }

    protected WeighBridgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WeighBridgeException(String message) {
        super(message);
    }
}
