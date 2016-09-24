package com.jinwei.service;

import java.math.BigDecimal;

import com.jinwei.model.Forder;


public interface ForderService extends BaseService<Forder> {
	//计算购物车的总价格
	public double cluTotal(Forder forder);
	
	public void updateStatusById(int id, int sid);
}
