package com.panda.spring.demo.action;/**
 * Created by My on 2019-11-30.
 */

import com.panda.spring.demo.service.IQueryService;
import com.panda.spring.framework.annotation.GPAutowired;
import com.panda.spring.framework.annotation.GPController;
import com.panda.spring.framework.annotation.GPRequestMapping;
import com.panda.spring.framework.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:19:08 2019-11-30
 * @Modified By:
 */
@GPController
@GPRequestMapping("/demo")
public class DemoAction {

    @GPAutowired private IQueryService queryService;
    @GPRequestMapping("/query")
    public void query(HttpServletRequest req, HttpServletResponse resp, @GPRequestParam("name")String name){
        String result = "My name is " + name;
        try {
            resp.getWriter().write(result);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
