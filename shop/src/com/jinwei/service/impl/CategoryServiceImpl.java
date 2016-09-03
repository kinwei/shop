package com.jinwei.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.jinwei.model.Category;
import com.jinwei.service.BaseService;
import com.jinwei.service.CategoryService;
import com.jinwei.util.HibernateSessionFactory;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService{


	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		return categoryDao.queryJoinAccount(type, page, size);

	}

	@Override
	public Long getCount(String type) {
		return categoryDao.getCount(type);
		
	}

	@Override
	public void deleteByIds(String ids) {
		categoryDao.deleteByIds(ids);
		
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		return categoryDao.queryByHot(hot);
	}
	
	}
