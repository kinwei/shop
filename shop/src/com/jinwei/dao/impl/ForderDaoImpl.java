package com.jinwei.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jinwei.dao.ForderDao;
import com.jinwei.model.Forder;
import com.jinwei.model.Sorder;
import com.jinwei.service.ForderService;

@Repository("forderDao")
public class ForderDaoImpl extends BaseDaoImpl<Forder> implements
		ForderDao {



	

	@Override
	public void updateStatusById(int id, int sid) {
		String hql = "UPDATE Forder f SET f.status.id=:sid WHERE f.id=:id";
		getSession().createQuery(hql).setInteger("sid", sid)//
		.setInteger("id", id).executeUpdate();
		
	}

}
