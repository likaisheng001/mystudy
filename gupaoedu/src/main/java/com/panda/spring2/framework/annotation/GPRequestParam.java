package com.panda.spring2.framework.annotation;/**
 * Created by My on 2019-11-30.
 */

import java.lang.annotation.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 15:32:01 2019-11-30
 * @Modified By:
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestParam {
    String value() default "";
    boolean required() default true;
}
