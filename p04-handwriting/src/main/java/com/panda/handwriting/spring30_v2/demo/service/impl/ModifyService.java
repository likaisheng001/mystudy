package com.panda.handwriting.spring30_v2.demo.service.impl;


import com.panda.handwriting.spring30_v2.demo.service.IModifyService;
import com.panda.handwriting.spring30_v2.framework.annotation.PService;

/**
 * 增删改业务
 * @author Tom
 *
 */
@PService
public class ModifyService implements IModifyService {

	/**
	 * 增加
	 */
	public String add(String name,String addr) throws Exception {
		throw new Exception("这是Vulcan故意跑出来的异常");
		//return "modifyService add,name=" + name + ",addr=" + addr;
	}

	/**
	 * 修改
	 */
	public String edit(Integer id,String name) {
		return "modifyService edit,id=" + id + ",name=" + name;
	}

	/**
	 * 删除
	 */
	public String remove(Integer id) {
		return "modifyService id=" + id;
	}
	
}
