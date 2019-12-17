package com.panda.spring2.framework.webmvc;/**
 * Created by My on 2019-12-16.
 */


import com.panda.spring2.framework.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:21:46 2019-12-16
 * @Modified By:
 */
public class GPHandlerAdapter {
    public boolean supports(Object handler){
        return (handler instanceof GPHandlerMappering);
    }
    public GPModelAndView handle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        GPHandlerMappering handlerMappering = (GPHandlerMappering)handler;

        //把方法的形参列表和request的参数列表所在的顺序一一对应
        Map<String,Integer> paramIndexMapping = new HashMap<String,Integer>();
        //提取方法中加了注解的参数
        //把方法上的注解拿到，得到的是一个二维数组
        //因为一个参数可以有多个注解，而一个方法又有多个参数
        Annotation[][] pa = handlerMappering.getMethod().getParameterAnnotations();
        for (int i = 0; i < pa.length; i++){
            for (Annotation a : pa[i]){
                if (a instanceof GPRequestParam){
                    String paramName = ((GPRequestParam)a).value();
                    if (!"".equals(paramName.trim())){
                        paramIndexMapping.put(paramName,i);
                    }
                }
            }
        }

        Class<?>[] parameterTypes = ((GPHandlerMappering) handler).getMethod().getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++){
            Class<?> type = parameterTypes[i];
            if (type == HttpServletRequest.class || type == HttpServletResponse.class){
                paramIndexMapping.put(type.getName(),i);
            }
        }
        //获取方法的形参列表
        Map<String,String[]> params = request.getParameterMap();
        //实参列表
        Object[] paramValues = new Object[parameterTypes.length];
        
        for (Map.Entry<String,String[]> param : params.entrySet()){
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]","")
                    .replaceAll("\\s",",");

            if (!paramIndexMapping.containsKey(param.getKey())){continue;};
            int index = paramIndexMapping.get(param.getKey());
            paramValues[index] = caseStringValue(value,parameterTypes[index]);
        }
        if (paramIndexMapping.containsKey(HttpServletRequest.class.getName())){
            int reqIndex = paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] =request;
        }
        if (paramIndexMapping.containsKey(HttpServletResponse.class.getName())){
            int respIndex = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] =response;
        }

        Object returnValue = handlerMappering.getMethod().invoke(handlerMappering.getController(),paramValues);
        if (returnValue == null || returnValue instanceof Void){return null;}

        boolean isModelAndView =  handlerMappering.getMethod().getReturnType() == GPModelAndView.class;
        if (isModelAndView){
            return (GPModelAndView)returnValue;
        }
        return null;
    }

    private Object caseStringValue(String value, Class<?> parameterType) {
        if (String.class == parameterType){
            return value;
        }
        if (Integer.class == parameterType){
            return Integer.valueOf(value);
        }else if (Double.class == parameterType){
            return Double.valueOf(value);
        }else {
            if (value != null){
                return value;
            }
            return null;
        }

    }
}
