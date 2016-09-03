package com.jinwei.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.jinwei.dao.AccountDao;
import com.jinwei.dao.BaseDao;
import com.jinwei.dao.CategoryDao;
import com.jinwei.dao.ForderDao;
import com.jinwei.dao.ProductDao;
import com.jinwei.dao.SorderDao;
import com.jinwei.dao.UserDao;
import com.jinwei.service.BaseService;

@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T>{

	private Class clazz;
	
	public BaseServiceImpl(){
		System.out.println(this);
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	@PostConstruct
	public void init(){
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0,1).toLowerCase() + clazzName.substring(1) + "Dao";
		try {
			Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
//	@Resource
//	private SessionFactory sessionFactory;
	protected BaseDao baseDao; //如果当前T 是account 则baseDao是accountDao 如果是category 则是categoryDao
	
	@Resource
	protected AccountDao accountDao;
	
	@Resource
	protected CategoryDao categoryDao;
	
	@Resource
	protected ForderDao forderDao;
	
	@Resource
	protected ProductDao productDao;
	
	@Resource
	protected SorderDao sorderDao;
	
	@Resource
	protected UserDao userDao;
	
	/*public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/
	
//	protected Session getSession(){
//		return sessionFactory.getCurrentSession();
//	}
	
	@Override
	public void save(T t) {
		baseDao.save(t);
		
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
		
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
		
	}

	@Override
	public T get(int id) {
		return (T)baseDao.get(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
			}

	
	

	
	
	
}
