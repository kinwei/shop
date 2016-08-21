package com.jinwei.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinwei.model.Category;
import com.jinwei.model.Product;
import com.jinwei.service.CategoryService;
import com.jinwei.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-*.xml")
public class ProductServiceImplTest {

	@Resource
	private ProductService productService;

	@Test
	public void queryJoinAccount() {
		for (Product temp : productService.queryJoinCategory("", 1, 5)) {
			System.out.println(temp);

		}
	}

	@Test
	public void queryByCid() {
		for (Product temp : productService.queryByCid(1)) {
			System.out.println(temp);

		}
	}
@Test
	public void get() {
		System.out.println(productService.get(1));
	}
}
