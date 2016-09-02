package com.jinwei.service;

import java.util.List;

import com.jinwei.model.Forder;
import com.jinwei.model.Product;
import com.jinwei.model.Sorder;

public interface SorderService extends BaseService<Sorder>{
	
	public Forder addSorder(Forder forder,Product product );
	
	public Forder updateSorder(Sorder sorder,Forder forder);
	
	//把商品数据转换成Sorder
	public Sorder productToSorder(Product product);
	
	public List<Object> querySale(int number);
}
