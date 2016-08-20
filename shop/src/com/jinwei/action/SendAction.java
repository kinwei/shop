package com.jinwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用来jsp与jsp界面转发功能 不处理任何业务逻辑
 * @author Administrator
 *
 */
@Controller
public class SendAction extends ActionSupport{
	public String execute(){
		return "send";
	}
}
