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
			session.put("user", model);
			//根据session中goURL中是否有值来决定跳转
			if(session.get("goURL") == null){
				return "index";
			}else{
				return "goURL";
			}
		}
	}
}
