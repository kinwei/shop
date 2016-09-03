package com.jinwei.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jinwei.dao.AccountDao;
import com.jinwei.model.Account;
import com.jinwei.model.Category;
import com.jinwei.service.AccountService;
import com.jinwei.service.BaseService;
import com.jinwei.service.CategoryService;
import com.jinwei.util.HibernateSessionFactory;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao{
	
	}
