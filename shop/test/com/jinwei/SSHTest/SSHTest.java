package com.jinwei.SSHTest;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinwei.model.Category;
import com.jinwei.service.CategoryService;
import com.jinwei.service.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-*.xml")
public class SSHTest {
	
	
	
	@Resource
	private CategoryService categoryService;
	
	
	
	
	/*@Test
	public void hibernate(){
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.save(new Category("男士休闲", true));	
	}*/
	
	@Test
	public void hibernateAndSpring(){
		categoryService.update(new Category(2,"nvshi",false));	
	}

}
