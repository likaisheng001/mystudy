package com.panda.handwriting.spring30.demo.action;/**
 * Created by My on 2019-11-30.
 */
import com.panda.handwriting.spring30.demo.service.IQueryService;
import com.panda.handwriting.spring300.framework.annotation.PAutowired;
import com.panda.handwriting.spring300.framework.annotation.PController;
import com.panda.handwriting.spring300.framework.annotation.PRequestMapping;
import com.panda.handwriting.spring300.framework.annotation.PRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Likaisheng
 * @Description:
 * @Date: Created in 17:19:08 2019-11-30
 * @Modified By:
 */
@PController
@PRequestMapping("/demo")
public class DemoAction {

    //http://localhost/demo/query?name=Tom&name=Vulcan&name=James
    //@PRequestMapping("/query")
    //http://localhost/demo/queryxxx?name=Tom
    //@PRequestMapping("/query.*")
    @PAutowired
    private IQueryService queryService;
    @PRequestMapping("/query.*")
    public void query(HttpServletRequest req, HttpServletResponse resp, @PRequestParam("name")String name){
        String result = "My name is " + name;
        try {
            resp.getWriter().write(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @PRequestMapping("/add")
    public void add(HttpServletRequest req,HttpServletResponse resp,
                    @PRequestParam("a")Integer a,@PRequestParam("b")Integer b){
        try{
            resp.getWriter().write(a + "+" + b + "=" + (a + b));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @PRequestMapping("/sub")
    public void sub(HttpServletRequest req,HttpServletResponse resp,
                    @PRequestParam("a")Double a,@PRequestParam("b")Double b){
        try{
            resp.getWriter().write(a + "-" + b + "=" + (a - b));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @PRequestMapping("/remove")
    public String remove(@PRequestParam("id")Integer id){
        return ""+id;
    }
}
