package com.jinwei.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.jinwei.dao.BaseDao;
import com.jinwei.model.Category;
import com.jinwei.service.BaseService;

@SuppressWarnings("unchecked")
@Service("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T>{

	private Class clazz;
	
	public BaseDaoImpl(){
		
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	
	@Resource
	private SessionFactory sessionFactory;
	
	
	/*public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(T t) {
		getSession().save(t);
		
	}

	@Override
	public void update(T t) {
		getSession().update(t);
		
	}

	@Override
	public void delete(int id) {
		String hql = "delete " + clazz.getSimpleName() +" where id=:id";
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
		
	}

	@Override
	public T get(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		String hql = "from " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	
	

	
	
	
}
