package com.panda.spring2.framework.aop.aspect;/**
 * Created by My on 2019-12-17.
 */

import java.lang.reflect.Method;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 18:19:09 2019-12-17
 * @Modified By:
 */
public interface GPJoinPoint {
    Object getThis();

    Object[] getArguments();

    Method getMethod();

    void setUserAttribute(String key, Object value);

    Object getUserAttribute(String key);
}
