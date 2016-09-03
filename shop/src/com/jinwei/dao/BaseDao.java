package com.jinwei.dao;

import java.util.List;

import com.jinwei.model.Category;

public interface BaseDao <T>{
	
	public void save(T t);
	
	public void update(T t);
	
	public void delete(int id);
	
	public T get(int id);
	
	public List<T> query();
}
