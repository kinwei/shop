package com.jinwei.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.Category;
import com.jinwei.model.Product;

@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {
	
	public String queryJoinCategory(){
		pageMap = new HashMap<String, Object>();	
		List<Product> productList = productService.queryJoinCategory(model.getName(), page, rows);
		Long total = productService.getCount(model.getName());
		pageMap.put("total",total);
		pageMap.put("rows",productList );
		
		return "jsonMap";
	}
	
	public void save(){
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		productService.save(model);
	}
	
	public String get(){
		request.put("product",productService.get(model.getId()));
		return "detail";
	}
}
