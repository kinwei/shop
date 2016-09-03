package com.jinwei.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jinwei.dao.CategoryDao;
import com.jinwei.model.Category;
import com.jinwei.service.BaseService;
import com.jinwei.service.CategoryService;
import com.jinwei.util.HibernateSessionFactory;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao{


	@SuppressWarnings("unchecked")
	@Override
	public List<Category> queryJoinAccount(String type, int page, int size) {
		String hql = "FROM Category c LEFT JOIN FETCH c.account WHERE c.type LIKE :type";
		return	getSession().createQuery(hql).
				setString("type", "%" + type + "%").setFirstResult((page-1)*size).setMaxResults(size)
				.list();

	}

	@Override
	public Long getCount(String type) {
		String hql = "SELECT count(c) from Category c WHERE c.type like :type";
		return (Long)getSession().createQuery(hql).setString("type", "%" + type + "%").uniqueResult();
		
	}

	@Override
	public void deleteByIds(String ids) {
		String hql = "DELETE FROM Category WHERE id in (" + ids + ")";
		getSession().createQuery(hql).executeUpdate();
		
	}

	@Override
	public List<Category> queryByHot(boolean hot) {
		// TODO Auto-generated method stub
		String hql = "FROM Category c WHERE c.hot=:hot";
		
		return getSession().createQuery(hql).setBoolean("hot", hot).list();
	}
	
	}
