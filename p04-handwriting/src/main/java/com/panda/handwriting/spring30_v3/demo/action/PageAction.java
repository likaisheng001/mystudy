package com.panda.handwriting.spring30_v3.demo.action;

import com.panda.handwriting.spring30_v3.demo.service.IQueryService;
import com.panda.handwriting.spring30_v3.framework.annotation.PAutowired;
import com.panda.handwriting.spring30_v3.framework.annotation.PController;
import com.panda.handwriting.spring30_v3.framework.annotation.PRequestMapping;
import com.panda.handwriting.spring30_v3.framework.annotation.PRequestParam;
import com.panda.handwriting.spring30_v3.framework.webmvc.servlet.PModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 公布接口url
 * @author Tom
 *
 */
@PController
@PRequestMapping("/")
public class PageAction {

    @PAutowired
    IQueryService queryService;

    // http://localhost/first.html?teacher=vulcan
    @PRequestMapping("/first.html")
    public PModelAndView query(@PRequestParam("teacher") String teacher){
        String result = queryService.query(teacher);
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("teacher", teacher);
        model.put("data", result);
        model.put("token", "123456");
        return new PModelAndView("first.html",model);
    }

}
