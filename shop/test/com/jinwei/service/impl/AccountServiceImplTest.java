package com.jinwei.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinwei.model.Account;
import com.jinwei.model.Category;
import com.jinwei.service.AccountService;
import com.jinwei.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class AccountServiceImplTest {
	
	@Resource
	private AccountService accountService;
	
	

	@Test
	public void testSave() {
		accountService.save(new Account("dongwuxiuxian","jinwei","jinwei"));	
	}

	@Test
	public void testUpdate() {
		accountService.update(new Account(1,"admin","xiaoxiao","xiaoxiao"));	
	}

	

	@Test
	public void testGet() {
		System.out.println(accountService.get(1));
	}

	@Test
	public void testQuery() {
		for(Account temp:accountService.query()){
			System.out.println(temp);
		}
	}
	
	@Test
	public void testDelete() {
		accountService.delete(2);
	}

}
