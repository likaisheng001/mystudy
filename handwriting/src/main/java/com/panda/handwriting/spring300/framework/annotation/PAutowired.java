package com.panda.handwriting.spring300.framework.annotation;/**
 * Created by My on 2019-12-22.
 */

import java.lang.annotation.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:19:03 2019-12-22
 * @Modified By:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PAutowired {
    String value() default "";
}
