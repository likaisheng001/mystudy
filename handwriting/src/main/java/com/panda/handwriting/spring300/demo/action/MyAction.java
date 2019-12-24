package com.panda.handwriting.spring300.demo.action;


import com.panda.handwriting.spring300.demo.service.IModifyService;
import com.panda.handwriting.spring300.demo.service.IQueryService;
import com.panda.handwriting.spring300.framework.annotation.PAutowired;
import com.panda.handwriting.spring300.framework.annotation.PController;
import com.panda.handwriting.spring300.framework.annotation.PRequestMapping;
import com.panda.handwriting.spring300.framework.annotation.PRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 公布接口url
 * @author Tom
 *
 */
@PController
@PRequestMapping("/web")
public class MyAction {

	@PAutowired
	IQueryService queryService;
	@PAutowired
	IModifyService modifyService;

	@PRequestMapping("/query.json")
	public void query(HttpServletRequest request, HttpServletResponse response,
								@PRequestParam("name") String name){
		String result = queryService.query(name);
		out(response,result);
	}
	
	@PRequestMapping("/add*.json")
	public void add(HttpServletRequest request,HttpServletResponse response,
			   @PRequestParam("name") String name,@PRequestParam("addr") String addr){
		String result = modifyService.add(name,addr);
		out(response,result);
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
	
	
	
	private void out(HttpServletResponse resp,String str){
		try {
			resp.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
