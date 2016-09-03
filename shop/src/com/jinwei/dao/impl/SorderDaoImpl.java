package com.jinwei.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jinwei.dao.SorderDao;
import com.jinwei.model.Forder;
import com.jinwei.model.Product;
import com.jinwei.model.Sorder;
import com.jinwei.service.SorderService;

@Repository("sorderDao")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements
		SorderDao{


	@Override
	public List<Object> querySale(int number) {
		String hql = "SELECT s.name,sum(s.number) FROM Sorder s JOIN s.product GROUP BY s.product.id";
		return getSession().createQuery(hql).setFirstResult(0).setMaxResults(number).list();
		
	}



	

}
