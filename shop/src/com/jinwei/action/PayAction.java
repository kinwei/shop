package com.jinwei.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.Forder;
import com.jinwei.model.SendData;
import com.jinwei.model.User;

@Controller("payAction")
@Scope("prototype")
public class PayAction extends BaseAction<SendData> {
	
	public String goBank(){
		//1.补全参数 p2 p3 pd pa需要从session中获取
		Forder forder = (Forder)session.get("oldForder");
		User user = (User)session.get("user");
		model.setP2_Order(forder.getId().toString());
		model.setP3_Amt(forder.getTotal().toString());
		model.setPa_MP(user.getEmail() + "," + user.getPhone());
		//2.对参数进行追加
		//3.加密获取签名
		//4.存储到request域中
		payService.saveDataToRequest(request, model);
		
		return "pay";
	}
}
