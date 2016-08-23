package com.jinwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	public String login(){
		//进行登录判断
		model = userService.login(model);
		if(model == null){
			session.put("error", "登录失败");
			return "ulogin";
		}else{
			return "index";
		}
	}
}
