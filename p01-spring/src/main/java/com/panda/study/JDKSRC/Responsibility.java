package com.panda.study.JDKSRC;

/**
 * Created by Administrator on 2019/8/7.
 */
public class Responsibility {
    public static void main(String[] args) {
        //DispatcherServlet
        //说明
        /**
         * 1.protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception{
         *     HandlerExecutionChain mappedHandler = null;
         *     ...
         *     mappedHandler = this.getHandler(processedRequest);//得到HandlerExecutionChain对象
         *     ...
         *     //在mappedHandler.applyPreHandle内部得到了 HandlerInterceptor interceptor
         *     //调用了拦截器的interceptor.preHandle方法
         *     if(!mappedHandler.applyPreHandle(processedRequest, response)) {
         *       return;
         *     }
         *     //说明：mappedHandler.applyPostHandle方法内部获取到拦截器，并调用
         *     //拦截器的interceptor.postHandle方法
         *     mappedHandler.applyPostHandle(processedRequest, response, mv);
         *
         *     //说明：在mappedHandler.applyPreHandle内部中
         *     还调用了triggerAfterCompletion方法,该方法中调用了
         *     try {
         *        interceptor.afterCompletion(request, response, this.handler, ex);
         *      } catch (Throwable var8) {
         *        logger.error("HandlerInterceptor.afterCompletion threw exception", var8);
         *      }
         * }
         */
    }
}
