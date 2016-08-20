package com.jinwei.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jinwei.model.FileImage;
import com.jinwei.service.AccountService;
import com.jinwei.service.CategoryService;
import com.jinwei.service.ProductService;
import com.jinwei.util.FileUpload;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware,ModelDriven<T> {
	protected Map<String, Object> application;
	protected Map<String, Object> session;
	protected Map<String, Object> request;
	
	protected Integer page;
	protected Integer rows;
	
	protected List<T> jsonList = null;
	
	protected FileImage fileImage;
	
	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	protected Map<String, Object> pageMap = null;
	
	protected String ids;
	
	protected InputStream inputStream;
	
	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	protected T model;
	@Resource
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	
	@Resource
	protected ProductService productService;
	@Resource
	protected FileUpload fileUpload;
	
/*	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}*/

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}
	
	

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class clazz = (Class)type.getActualTypeArguments()[0];
		try {
			model = (T)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return model;
	}

}
