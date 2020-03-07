package com.panda.study.designmodel_gp.decorator.logger;/**
 * Created by My on 2020-03-07.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:47:29 2020-03-07
 * @Modified By:
 */
public class JsonLogger extends LoggerDecorator {

    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String s) {
        super.info(s);
    }

    @Override
    public void error(String s) {
        JSONObject result = newJsonObject();
        result.put("message",s);
        logger.info(result.toString());
    }

    public void error(Exception e){
        JSONObject result = newJsonObject();
        result.put("exception",e.getClass().getName());
        String trace = Arrays.toString(e.getStackTrace());
        result.put("stackTrace",trace);
        logger.info(result.toString());
    }
    private JSONObject newJsonObject(){
        return new JSONObject();
    }
}

