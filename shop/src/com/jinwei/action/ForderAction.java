package com.jinwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.Forder;
import com.jinwei.model.Status;
import com.jinwei.model.User;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder>{
	
	

	//此方式不安全
	public Forder getModel() {
		model = (Forder)session.get("forder");
		return model;
	}

	//实现购物车（订单）与购物项（订单项）级联入库功能
	public String save(){
/*	//把session中的购物项交给model对象
		Forder forder = (Forder) session.get("forder");
		model.setSorderSet(forder.getSorderSet());
		forder.setAddress(model.getAddress());
		forder.setName(model.getName());
		forder.setPhone(model.getPhone());
		forder.setRemark(model.getRemark());
		//级联入库（需要在XML中配置）需要sorder关联forder，在SorderServiceImpl中追加sorder.setForder(forder)

		model.setUser((User)session.get("user"));
		model.setStatus(new Status(1));
		//forderService.save(forder);
		forderService.save(model);
		
		session.put("oldForder", session.get("forder")); 
		
		
		
		return "bank";
		*/
		
		Forder forder=(Forder)session.get("forder");
		
		forder.setAddress(model.getAddress());
		forder.setPhone(model.getPhone());
		forder.setName(model.getName());
		forder.setRemark(model.getRemark());
		forder.setPost(model.getPost());
		forder.setUser((User)session.get("user"));
		forder.setStatus(new Status(1));
		//。。。。。。
		forderService.save(forder);
		session.put("oldForder", session.get("forder"));
		// 此时购物车已经入库, 那么原来session中的购物车就应该清空
		session.put("forder", new Forder());
		return "bank";
	}
}
