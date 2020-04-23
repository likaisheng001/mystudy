package com.panda.handwriting.spring30_v3.framework.aop.aspect;/**
 * Created by My on 2020-04-23.
 */

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 16:45:59 2020-04-23
 * @Modified By:
 */
public interface PJoinPoint {
    Object getThis();

    Object[] getArguments();

    Method getMethod();

    void setUserAttribute(String key,Object value);

    Object getUserAttribute(String key);
}
