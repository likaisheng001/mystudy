package com.panda.pattern.delegate.mvc;/**
 * Created by My on 2019-12-09.
 */

import com.panda.pattern.delegate.mvc.controller.MemberController;
import com.panda.pattern.delegate.mvc.controller.OrderController;
import com.panda.pattern.delegate.mvc.controller.SystemController;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 20:21:46 2019-12-09
 * @Modified By:
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //完成调度
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");

        if ("getMemberById".equals(uri)){
            new MemberController().getMemberById(mid);
        }else if("getOrderById".equals(uri)){
            new OrderController().getOrderById(mid);
        }else if ("logout".equals(uri)){
            new SystemController().logout();
        }else{
            resp.getWriter().write("404 not found!!!");
        }
    }
}
