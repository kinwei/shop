package com.jinwei.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.BackData;
import com.jinwei.model.Forder;
import com.jinwei.model.SendData;
import com.jinwei.model.User;
/*
 * Structs 处理流程：获取请求后 先创建Action代理 在创建Action代理的时候顺便创建了Action 执行18个拦截器  
 * 拦截器执行成功在调用Action的方法  Action方法执行完后，在返回执行拦截器
 * 
 * 创建Action---->servletConfig----->modelDriven
 * */

@Controller("payAction")
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware{
	
	private Map<String, String[]> parameters;
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		// TODO Auto-generated method stub
		this.parameters = parameters;
	}
	
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if(parameters.get("pd_FrpId") != null){
			model = new SendData();
		}else{
			model = new BackData();
		}
		return model;
	}



	public String goBank(){
		SendData sendDate = (SendData) model;
		//1.补全参数 p2 p3 pd pa需要从session中获取
		Forder forder = (Forder)session.get("oldForder");
		User user = (User)session.get("user");
		sendDate.setP2_Order(forder.getId().toString());
		sendDate.setP3_Amt(forder.getTotal().toString());
		sendDate.setPa_MP(user.getEmail() + "," + user.getPhone());
		//2.对参数进行追加
		//3.加密获取签名
		//4.存储到request域中
		payService.saveDataToRequest(request, sendDate);
		
		return "pay";
	}
	
	public String backBank(){
		BackData backData = (BackData) model;
		boolean isOk = payService.checkBackData(backData);
		
		if(isOk){
			//更改订单状态
			//根据user的邮箱 发送邮件
			String address = backData.getR8_MP().split(".")[0];
			emailUtil.sendEmail(address, backData.getR6_Order());
			//发送手机短信
			System.out.println("---------ssss-------");
		}else {
			System.out.println("-----ffff-------");
		}
		
		return "";
	}

}
