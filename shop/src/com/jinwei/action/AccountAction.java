package com.jinwei.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.Account;
import com.jinwei.model.Category;
import com.jinwei.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	
	
	
	
	public String query(){
		jsonList = accountService.query();
		
		return "jsonList";
	}
	
	public String aindex(){
		return "aindex";
	}
	
}
