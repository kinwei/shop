 package com.jinwei.service;

import java.util.List;

import com.jinwei.model.Category;

public interface CategoryService extends BaseService<Category>{
	//查询类别信息 级联管理员
	public List<Category> queryJoinAccount(String type,int page, int size);
	
	public Long getCount(String type);
	
	public void deleteByIds(String ids);
	
	public List<Category> queryByHot(boolean hot);
}
