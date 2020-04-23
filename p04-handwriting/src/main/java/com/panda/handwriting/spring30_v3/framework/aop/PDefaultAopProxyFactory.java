package com.panda.handwriting.spring30_v3.framework.aop;/**
 * Created by My on 2020-04-23.
 */

import com.panda.handwriting.spring30_v3.framework.aop.support.PAdvicedSupport;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 19:32:57 2020-04-23
 * @Modified By:
 */
public class PDefaultAopProxyFactory {
    public PAopProxy createAopProxy(PAdvicedSupport config) throws Exception{
        Class targetClass = config.getTargetClass();
        if (targetClass.getInterfaces().length > 0){
            return new PJdkDynamicAopProxy(config);
        }
        return new PCglibAopProxy();
    }
}
