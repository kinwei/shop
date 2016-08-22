package com.jinwei.service;

import com.jinwei.model.Forder;
import com.jinwei.model.Product;
import com.jinwei.model.Sorder;

public interface SorderService extends BaseService<Sorder>{
	
	public Forder addSorder(Forder forder,Product product );
	
	//把商品数据转换成Sorder
	public Sorder productToSorder(Product product);
}
