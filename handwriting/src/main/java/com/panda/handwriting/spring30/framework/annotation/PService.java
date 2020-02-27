package com.panda.handwriting.spring30.framework.annotation;/**
 * Created by My on 2019-12-22.
 */

import java.lang.annotation.*;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 13:17:33 2019-12-22
 * @Modified By:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PService {
    String value() default "";
}
