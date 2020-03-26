package com.panda.study.designmodel_gp.delegate.mvc;

import com.panda.study.designmodel_gp.delegate.mvc.controllers.MemberController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom.
 */
public class DispatcherServlet extends HttpServlet {
    private Map<String,Method> handlerMapping = new HashMap<String,Method>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        Method method = handlerMapping.get(uri);
//        method.invoke()
    }

    @Override
    public void init() throws ServletException {
        try {
            handlerMapping.put("/web/getMemberById.json",MemberController.class.getMethod("getMemberById",new Class[]{String.class}));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
