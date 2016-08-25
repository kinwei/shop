package com.jinwei.service;

import java.util.Map;

import com.jinwei.model.BackData;
import com.jinwei.model.SendData;

public interface PayService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.it.shop.service.impl.PayService#saveDataToRequest(java.util.Map,
	 * cn.it.shop.model.SendData)
	 */
	/* (non-Javadoc)
	 * @see com.jinwei.service.impl.PayService#saveDataToRequest(java.util.Map, com.jinwei.model.SendData)
	 */
	public abstract Map<String, Object> saveDataToRequest(
			Map<String, Object> request, SendData sendData);

	public abstract boolean checkBackData(BackData backData);

}