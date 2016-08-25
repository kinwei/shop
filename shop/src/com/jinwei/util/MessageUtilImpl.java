package com.jinwei.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

/*
 * http://utf8.sms.webchinese.cn/?Uid=本站用户名&Key=4c7755315708e1f89deb&smsMob=手机号码&smsText=验证码:8888
 * */
@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {
	
	
	/* (non-Javadoc)
	 * @see com.jinwei.util.MessageUtil#sendMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendMessage( String number,String id){
		//1.打开浏览器
		HttpClient client = new HttpClient();
		//2.创建请求的方式 get/post
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		//3.设置请求的参数信息
		
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");//在头文件中设置转码
		post.setParameter("Uid", "kinwei");
		post.setParameter("Key", "4c7755315708e1f89deb");
		post.setParameter("smsMob", "13203168780");
		post.setParameter("smsText", "订单已经支付成功");
		
		try {
			int code = 0;
			code = client.executeMethod(post);
			//获取服务器端返回的数据信息
			String result = post.getResponseBodyAsString();
			
			System.out.println("短信发送结果为：" + result);
			System.out.println("HTTP返回了" + code);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			post.releaseConnection();
		}
		
		
		
	}

}
