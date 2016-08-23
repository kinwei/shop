package com.jinwei.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jinwei.model.Forder;
import com.jinwei.model.Product;
import com.jinwei.model.Sorder;
import com.jinwei.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	
	@Override
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave = false;
		Sorder sorder = productToSorder(product);
		//判断当前购物项是否重复 如果重复则只增加数量即可 
		for(Sorder old:forder.getSorderSet()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//购物项有重复 添加数量即可
				old.setNumber(old.getNumber() + sorder.getNumber());
				isHave = true;
				break;
			}
		}
		
		if(!isHave){
			//说明当前购物项 在购物车中是不存在的 新添加即可
			forder.getSorderSet().add(sorder);
		}
				return forder;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	

}
