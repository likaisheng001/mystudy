package com.panda.handwriting.spring30_v3.demo.action;


import com.panda.handwriting.spring30_v3.demo.service.IModifyService;
import com.panda.handwriting.spring30_v3.demo.service.IQueryService;
import com.panda.handwriting.spring30_v3.framework.annotation.PAutowired;
import com.panda.handwriting.spring30_v3.framework.annotation.PController;
import com.panda.handwriting.spring30_v3.framework.annotation.PRequestMapping;
import com.panda.handwriting.spring30_v3.framework.annotation.PRequestParam;
import com.panda.handwriting.spring30_v3.framework.webmvc.servlet.PModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 公布接口url
 * @author Tom
 *
 */
@PController
@PRequestMapping("/web")
public class MyAction {

	// http://localhost/web/add.json?name=Vulcan&addr=ChongQing
	@PAutowired
    IQueryService queryService;
	@PAutowired
    IModifyService modifyService;

	@PRequestMapping("/query.json")
	public PModelAndView query(HttpServletRequest request, HttpServletResponse response,
                               @PRequestParam("name") String name){
		String result = queryService.query(name);
	 	return out(response,result);
	}
	
	@PRequestMapping("/add*.json")
	public PModelAndView add(HttpServletRequest request, HttpServletResponse response,
                             @PRequestParam("name") String name, @PRequestParam("addr") String addr){
		try {
			String result = modifyService.add(name,addr);
		    return out(response,result);
		}catch (Throwable e){
			// e.printStackTrace();
			Map<String,String> model = new HashMap<String,String>();
			model.put("detail",e.getCause().getMessage());
			model.put("stackTrace", Arrays.toString(e.getStackTrace()));
			return new PModelAndView("500",model);
		}
	}
	
	@PRequestMapping("/remove.json")
	public void remove(HttpServletRequest request,HttpServletResponse response,
		   @PRequestParam("id") Integer id){
		String result = modifyService.remove(id);
		out(response,result);
	}
	
	@PRequestMapping("/edit.json")
	public void edit(HttpServletRequest request,HttpServletResponse response,
			@PRequestParam("id") Integer id,
			@PRequestParam("name") String name){
		String result = modifyService.edit(id,name);
		out(response,result);
	}
	
	private PModelAndView out(HttpServletResponse resp, String str){
		try {
			resp.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
