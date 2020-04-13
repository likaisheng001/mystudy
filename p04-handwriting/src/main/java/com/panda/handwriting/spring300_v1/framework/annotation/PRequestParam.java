package com.panda.handwriting.spring300_v1.framework.annotation;/**
 * Created by My on 2019-12-22.
 */

import java.lang.annotation.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:21:08 2019-12-22
 * @Modified By:
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PRequestParam {
    String value() default "";
    boolean required() default true;
}
