package com.jinwei.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jinwei.model.Category;
import com.jinwei.model.Product;
import com.jinwei.service.AccountService;
import com.jinwei.service.CategoryService;
import com.jinwei.service.ProductService;

public class InitDataListener implements ServletContextListener {

	private ProductService productService = null;
	private CategoryService categoryService = null;
	private AccountService accountService = null;
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		//方案1：不可取  会加载两次Spring配置文件
		/*ApplicationContext context = new ClassPathXmlApplicationContext("appliactionContext-*.xml");
		ProductService productService = (ProductService) context.getBean("productService");*/
		
		//方案2：项目在启动的时候通过监听器加载Spring配置文件 存储到了ServletContext 中  只需要从中获取即可
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productService = (ProductService) context.getBean("productService");
		categoryService = (CategoryService) context.getBean("categoryService");
		accountService = (AccountService) context.getBean("accountService");
		List<List<Product>> bigList = new ArrayList<List<Product>>();
		
		for(Category category:categoryService.queryByHot(true)){
			bigList.add(productService.queryByCid(category.getId()));
		}
		
		event.getServletContext().setAttribute("bigList", bigList); 

	}

}
