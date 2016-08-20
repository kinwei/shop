package com.jinwei.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.Category;
import com.jinwei.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {
	
	public String queryJoinAccount(){
		pageMap = new HashMap<String, Object>();
		
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		Long total = categoryService.getCount(model.getType());
		pageMap.put("total",total);
		pageMap.put("rows",categoryList );
		
		return "jsonMap";
	}
	
	public String  deleteByIds(){
		categoryService.deleteByIds(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	public void save(){
		categoryService.save(model);
	}
	public void update(){
		categoryService.update(model);
	}
	
	public String query(){
		jsonList = categoryService.query();
		return "jsonList";
	}
	
}
