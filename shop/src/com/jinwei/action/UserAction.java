package com.jinwei.action;

import java.io.ByteArrayInputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.Forder;
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
	
	public String queryByLoginName(){
		String userName = (String) request.get("login");
		User user = new User();
		user.setLogin(userName);
		if(userService.queryByLoginName(user)){
			inputStream = new ByteArrayInputStream("true".getBytes());
		}else{
			inputStream = new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
	
	public String logout(){
		if(session.get("user") != null){
			session.remove("user");
			
		}
		return "logout_success";
	}
	
	public String add(){
		String login = (String) request.get("login");
		String name = (String) request.get("name");
		String pass = (String) request.get("pass");
		String sex = (String) request.get("sex");
		String email = (String) request.get("email");
		String phone = (String) request.get("phone");
		User user = new User(login, name, pass, sex, phone, email);
		userService.save(user);
		return "add_success";
	}
	
}
