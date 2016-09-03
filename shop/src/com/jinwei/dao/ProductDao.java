package com.jinwei.dao;

import java.util.List;

import com.jinwei.model.Category;
import com.jinwei.model.Product;

public interface ProductDao extends BaseDao<Product>{
	
	public List<Product> queryJoinCategory(String name,int page, int size);
	
	public Long getCount(String name);
	
	public List<Product> queryByCid(int cid);
	
}
