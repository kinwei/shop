package com.jinwei.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.jinwei.model.Category;
import com.jinwei.model.Product;
import com.jinwei.service.AccountService;
import com.jinwei.service.CategoryService;
import com.jinwei.service.ProductService;
/*
 * 加载后台商品信息到前台
 * */
@Component
public class ProductTimerTask extends TimerTask{
	@Resource
	private ProductService productService = null;
	@Resource
	private CategoryService categoryService = null;
	@Resource
	private AccountService accountService = null;
	
	private ServletContext application = null;
	
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public void run() {
		List<List<Product>> bigList = new ArrayList<List<Product>>();
		
		for(Category category:categoryService.queryByHot(true)){
			bigList.add(productService.queryByCid(category.getId()));
		}
		
		application.setAttribute("bigList", bigList); 

	}

}
