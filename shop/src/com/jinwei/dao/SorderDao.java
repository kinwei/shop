package com.jinwei.dao;

import java.util.List;

import com.jinwei.model.Forder;
import com.jinwei.model.Product;
import com.jinwei.model.Sorder;

public interface SorderDao extends BaseDao<Sorder>{
	
	
	public List<Object> querySale(int number);
}
