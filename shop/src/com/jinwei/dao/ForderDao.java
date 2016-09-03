package com.jinwei.dao;

import java.math.BigDecimal;

import com.jinwei.model.Forder;


public interface ForderDao extends BaseDao<Forder> {
	
	
	public void updateStatusById(int id, int sid);
}
