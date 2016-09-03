package com.jinwei.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jinwei.model.Product;
import com.jinwei.service.ProductService;

@Service("productService")
@SuppressWarnings("unchecked")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements
		ProductService {


	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		return productDao.queryJoinCategory(name, page, size);
	}

	@Override
	public Long getCount(String name) {
		return productDao.getCount(name);
		
	}

	@Override
	public List<Product> queryByCid(int cid) {
		return productDao.queryByCid(cid);
	}

	

}
