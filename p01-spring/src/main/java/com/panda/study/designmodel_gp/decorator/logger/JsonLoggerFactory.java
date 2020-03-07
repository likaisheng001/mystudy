package com.panda.study.designmodel_gp.decorator.logger;/**
 * Created by My on 2020-03-07.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:54:04 2020-03-07
 * @Modified By:
 */
public class JsonLoggerFactory {
    public static JsonLogger getLogger(Class clazz){
        Logger logger = LoggerFactory.getLogger(clazz);
        return new JsonLogger(logger);
    }
}
