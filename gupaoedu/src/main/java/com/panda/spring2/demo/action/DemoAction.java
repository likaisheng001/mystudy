package com.panda.spring2.demo.action;/**
 * Created by My on 2019-11-30.
 */

import com.panda.spring2.demo.service.IQueryService;
import com.panda.spring2.framework.annotation.GPAutowired;
import com.panda.spring2.framework.annotation.GPController;
import com.panda.spring2.framework.annotation.GPRequestMapping;
import com.panda.spring2.framework.annotation.GPRequestParam;

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

    //http://localhost/demo/query?name=Tom&name=Vulcan&name=James
    //@GPRequestMapping("/query")
    //http://localhost/demo/queryxxx?name=Tom
    //@GPRequestMapping("/query.*")
    @GPAutowired
    private IQueryService queryService;
    @GPRequestMapping("/query.*")
    public void query(HttpServletRequest req, HttpServletResponse resp, @GPRequestParam("name")String name){
        String result = "My name is " + name;
        try {
            resp.getWriter().write(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @GPRequestMapping("/add")
    public void add(HttpServletRequest req,HttpServletResponse resp,
                    @GPRequestParam("a")Integer a,@GPRequestParam("b")Integer b){
        try{
            resp.getWriter().write(a + "+" + b + "=" + (a + b));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @GPRequestMapping("/sub")
    public void sub(HttpServletRequest req,HttpServletResponse resp,
                    @GPRequestParam("a")Double a,@GPRequestParam("b")Double b){
        try{
            resp.getWriter().write(a + "-" + b + "=" + (a - b));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @GPRequestMapping("/remove")
    public String remove(@GPRequestParam("id")Integer id){
        return ""+id;
    }
}
