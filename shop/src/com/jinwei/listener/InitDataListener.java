package com.jinwei.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jinwei.model.Category;
import com.jinwei.model.Product;
import com.jinwei.service.AccountService;
import com.jinwei.service.CategoryService;
import com.jinwei.service.ProductService;
import com.jinwei.util.FileUpload;
import com.jinwei.util.ProductTimerTask;

public class InitDataListener implements ServletContextListener {
	
	private ProductTimerTask productTimerTask = null;
	
	private FileUpload fileUpload = null;
	
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
		productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");
		fileUpload = (FileUpload) context.getBean("fileUpload");
		productTimerTask.setApplication(event.getServletContext());
		new Timer(true).schedule(productTimerTask, 0,1000*60*60);
		
		event.getServletContext().setAttribute("bankList", fileUpload.getBankImage());
		
		//项目启动时要加载银行的图标
		
	}

}
