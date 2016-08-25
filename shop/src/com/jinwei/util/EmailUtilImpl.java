package com.jinwei.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil {
	/* (non-Javadoc)
	 * @see com.jinwei.util.MessageUtil#sendEmail(java.lang.String, int)
	 */
	@Override
	public  void sendEmail(String address,String id){
		Session session = null;
		Message message = null;
		Transport transport = null;
		//登录邮件客户端
		Properties prop = new Properties();
		try{
		prop.setProperty("mail.transport.protocol", "smtp");
		//创建Session会话
		 session = Session.getDefaultInstance(prop);
		//创建邮件对象
		session.setDebug(true);
		 message = new MimeMessage(session);
		
		//写信
		message.setSubject("订单支付成功");
		message.setContent("订单"+ id +"已经支付成功","text/html;charset=utf-8");
		message.setFrom(new InternetAddress("soft03_test@sina.com"));
		//收件人地址
		 transport = session.getTransport();
		transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
		transport.sendMessage(message,new Address[]{new InternetAddress(address)});
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
		try {
			transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
