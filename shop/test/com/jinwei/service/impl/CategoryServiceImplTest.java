package com.jinwei.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinwei.model.Category;
import com.jinwei.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class CategoryServiceImplTest {
	
	@Resource
	private CategoryService categoryService;
	
	

	@Test
	public void testSave() {
		categoryService.save(new Category("dongwuxiuxian",true));	
	}

	@Test
	public void testUpdate() {
		categoryService.update(new Category(2,"小孩休闲",false));	
	}

	

	@Test
	public void testGet() {
		System.out.println(categoryService.get(1));
	}

	@Test
	public void testQuery() {
		for(Category temp:categoryService.query()){
			System.out.println(temp);
		}
	}
	
	@Test
	public void testDelete() {
		categoryService.delete(2);
	}
	
	@Test
	public void queryJoinAccount() {
		for(Category temp:categoryService.queryJoinAccount("",1,1)){
			System.out.println(temp);
			System.out.println(temp.getAccount());
		}
	}
	
	@Test
	public void getCount() {
		
			System.out.println(categoryService.getCount(""));
		
	}
	
	@Test
	public void deleteByIds() {
		
		categoryService.deleteByIds("6,7,8,9,10,11");
		
	}

}
