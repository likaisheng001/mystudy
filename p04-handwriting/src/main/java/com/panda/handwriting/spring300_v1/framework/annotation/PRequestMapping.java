package com.panda.handwriting.spring300_v1.framework.annotation;/**
 * Created by My on 2019-12-22.
 */

import java.lang.annotation.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:22:43 2019-12-22
 * @Modified By:
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PRequestMapping {
    String value() default "";
}
