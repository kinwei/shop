package com.jinwei.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.jinwei.model.Forder;
import com.jinwei.model.Sorder;
import com.jinwei.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements
		ForderService {



	@Override
	public BigDecimal cluTotal(Forder forder) {
		BigDecimal total = new BigDecimal(0.00);
		for(Sorder temp:forder.getSorderSet()){
			total.add(temp.getPrice().multiply(new BigDecimal(temp.getNumber())));
		}
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		String hql = "UPDATE Forder f SET f.status.id=:sid WHERE f.id=:id";
		getSession().createQuery(hql).setInteger("sid", sid)//
		.setInteger("id", id).executeUpdate();
		
	}

}
