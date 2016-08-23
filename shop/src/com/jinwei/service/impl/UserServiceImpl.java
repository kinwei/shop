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
		String hql = "FROM User u WHERE u.login=:login AND u.pass=:pass";
		return (User)getSession().createQuery(hql)//
				.setString("login", user.getLogin())//
				.setString("pass", user.getPass())//
		.uniqueResult();
		
	}
	
	}
