package com.panda.handwriting.spring30_v2.framework.webmvc.servlet;/**
 * Created by My on 2020-04-12.
 */

import com.panda.handwriting.spring30_v2.framework.annotation.PRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 14:19:38 2020-04-12
 * @Modified By:
 */
public class PHandlerAdapter {

    public PModelAndView handler(HttpServletRequest req, HttpServletResponse resp, PHandlerMapping handler) throws InvocationTargetException, IllegalAccessException {

        // 保存形参列表
        // 将参数名称和参数的位置这种关系保存起来
        Map<String,Integer> paramIndexMapping = new HashMap<String,Integer>();

        Method method = handler.getMethod();
        Annotation[][] pa = handler.getMethod().getParameterAnnotations();
        for (int i = 0; i < pa.length; i++) {
            for (Annotation a : pa[i]){
                if (a instanceof PRequestParam){
                    String paramName = ((PRequestParam) a).value();
                    if (!"".equals(paramName.trim())){
                        paramIndexMapping.put(paramName,i);
                    }
                }
            }
        }
        // 初始化一下
        Class<?>[] paramTypes = handler.getMethod().getParameterTypes();
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> paramterType = paramTypes[i];
            if (paramterType == HttpServletRequest.class || paramterType == HttpServletResponse.class){
                paramIndexMapping.put(paramterType.getName(),i);
            }
        }
        // 拼接实参列表
        Map<String,String[][]> params = req.getParameterMap();
        Object[] paramValues = new Object[paramTypes.length];

        for (Map.Entry<String,String[][]> param : params.entrySet()){
            String value = Arrays.toString(params.get(param.getKey()))
                    .replaceAll("\\[|\\]","")
                    .replaceAll("\\s+",",");
            if (!paramIndexMapping.containsKey(param.getKey())){continue;}

            int index = paramIndexMapping.get(param.getKey());
            // TODO 类型转换 - 此处需自己完善，暂时硬编码
            // 允许自定义的类型转换器Converter
            paramValues[index] = castStringValue(value,paramTypes[index]);
        }

        if (paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int index = paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[index] = req;
        }

        if (paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int index = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[index] = resp;
        }

        Object result = handler.getMethod().invoke(handler.getController(), paramValues);
        if (result == null || result instanceof Void){return null;}

        boolean isModelAndView = handler.getMethod().getReturnType() == PModelAndView.class;
        if (isModelAndView){
            return (PModelAndView) result;
        }
        return null;
    }

    private Object castStringValue(String value, Class<?> paramType) {
        if (String.class == paramType) {
            return value;
        }else if (Integer.class == paramType){
            return Integer.valueOf(value);
        }else if (Double.class == paramType){
            return Double.valueOf(value);
        }else{
           if (value != null){
               return value;
           }
           return null;
        }
    }
}
