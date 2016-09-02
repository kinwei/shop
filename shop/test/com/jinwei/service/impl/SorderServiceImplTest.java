package com.jinwei.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinwei.model.Category;
import com.jinwei.model.Product;
import com.jinwei.service.CategoryService;
import com.jinwei.service.ProductService;
import com.jinwei.service.SorderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-*.xml")
public class SorderServiceImplTest {

	@Resource
	private SorderService sorderService;

	@Test
	public void querySale() {
		System.out.println(JSONSerializer.toJSON(sorderService.querySale(5)));
//		for (Object temp:sorderService.querySale(5)){
//			System.out.println(temp);

		}
	}

	

