package com.jinwei.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.jinwei.model.Account;
import com.jinwei.model.Category;
import com.jinwei.model.User;
import com.jinwei.service.AccountService;
import com.jinwei.service.BaseService;
import com.jinwei.service.CategoryService;
import com.jinwei.service.UserService;
import com.jinwei.util.HibernateSessionFactory;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Override
	public User login(User user) {
		return userDao.login(user);
		
	}

	@Override
	public boolean queryByLoginName(User user) {
		// TODO Auto-generated method stub
		return userDao.queryByLoginName(user);
	}
	
	
	
	}
