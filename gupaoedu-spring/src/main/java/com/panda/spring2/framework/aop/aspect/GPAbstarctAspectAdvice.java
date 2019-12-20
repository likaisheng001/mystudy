package com.panda.spring2.framework.aop.aspect;/**
 * Created by My on 2019-12-17.
 */

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:25:23 2019-12-17
 * @Modified By:
 */
public abstract class GPAbstarctAspectAdvice implements GPAdvice{
  private Method aspectMethod;
  private Object aspectTarget;
    public GPAbstarctAspectAdvice(Method aspectMethod,Object aspectTarget){
        this.aspectMethod = aspectMethod;
        this.aspectTarget = aspectTarget;
    }

    public Object invokeAdviceMethod(GPJoinPoint joinPoint, Object returnValue, Throwable tx)throws Throwable{
        Class<?>[] parameterTypes = this.aspectMethod.getParameterTypes();
        if (null == parameterTypes || parameterTypes.length == 0){
            return this.aspectMethod.invoke(aspectTarget);
        }else {
            Object[] args = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length ; i++){
                if (parameterTypes[i] == GPJoinPoint.class){
                    args[i] = joinPoint;
                }else if (parameterTypes[i] == Throwable.class){
                    args[i] = tx;
                }else if (parameterTypes[i] == Object.class){
                    args[i] =returnValue;
                }
            }
            return this.aspectMethod.invoke(aspectTarget,args);
        }
    }
}
