package com.jinwei.action;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.jinwei.model.Forder;
import com.jinwei.model.Product;
import com.jinwei.model.Sorder;
import com.opensymphony.xwork2.ActionContext;
import com.sun.mail.iap.ByteArray;

@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {
	
	public String updateSorder(){
		Forder forder = (Forder)session.get("forder");
		forder = sorderService.updateSorder(model, forder);
		forder.setTotal(forderService.cluTotal(forder));
		session.put("forder", forder);
		inputStream = new ByteArrayInputStream((""+forder.getTotal()).getBytes());
		return "stream";
	}
	
	public  String addSorder(){
		// 1.根据product.id获取相应商品信息
		Product product = productService.get(model.getProduct().getId());
		
		// 2.判断session中是否有购物车 如果没有则创建
		if(session.get("forder") == null){
			//创建购物车 并放入session中
			session.put("forder", new Forder(new HashSet<Sorder>()));
		}
		// 3.把商品信息转换成sorder 并且添加到购物车中（判断购物项是否重复）
		
		
		Forder forder = (Forder)session.get("forder");
		forder = sorderService.addSorder(forder, product);
		//4. 计算商品总价格
		forder.setTotal(forderService.cluTotal(forder));
		//5.把新的购物车存储到session中
		session.put("forder", forder);
		
		return "showCar";
	}
	
	public String querySale(){
		System.out.println("-----00-----");
		List<Object> jsonList = sorderService.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
}
