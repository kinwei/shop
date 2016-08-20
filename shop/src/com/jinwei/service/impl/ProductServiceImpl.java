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
		String hql = "FROM Product p LEFT JOIN FETCH p.category WHERE p.name LIKE :name";
		return	getSession().createQuery(hql).
				setString("name", "%" + name + "%").setFirstResult((page-1)*size).setMaxResults(size)
				.list();
	}

	@Override
	public Long getCount(String name) {
		String hql = "SELECT count(p) from Product p WHERE p.name like :name";
		return (Long)getSession().createQuery(hql).setString("name", "%" + name + "%").uniqueResult();
		
	}

	@Override
	public List<Product> queryByCid(int cid) {
		String hql = "FROM Product p WHERE p.commend=true AND p.open=true AND p.category.id=:cid ORDER BY p.date DESC";
		return getSession().createQuery(hql).setInteger("cid", cid).setFirstResult(0).setMaxResults(4).list();
		
	}

	

}
