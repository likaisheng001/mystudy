package com.panda.handwriting.spring30_v3.demo.aspect;


import com.panda.handwriting.spring30_v3.framework.aop.aspect.PJoinPoint;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Tom.
 */
@Slf4j
public class LogAspect {

    //在调用一个方法之前，执行before方法
    public void before(PJoinPoint joinPoint){
        joinPoint.setUserAttribute("startTime_" + joinPoint.getMethod().getName(),System.currentTimeMillis());
        //这个方法中的逻辑，是由我们自己写的
        log.info("Invoker Before Method!!!");
    }
    //在调用一个方法之后，执行after方法
    public void after(PJoinPoint joinPoint){
        long startTime = (long) joinPoint.getUserAttribute("startTime_" + joinPoint.getMethod().getName());
        long endTime = System.currentTimeMillis();
        log.info("Invoker After Method!!!" + "use time : " + (endTime - startTime));
    }

    public void afterThrowing(PJoinPoint joinPoint,Throwable tx){

        log.info("出现异常");
    }
}
