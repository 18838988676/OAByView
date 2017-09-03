package com.zhy.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.domain.User;

public class TestConnection {

	@Test
	public void testConnection(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SessionFactory factory= (SessionFactory) context.getBean("sessionFactory");
		System.out.println(factory);
	}
	
	/**
	 * 添加用户
	 */
	@Test
	public void addUser(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		SessionFactory factory= (SessionFactory) context.getBean("sessionFactory");
		Session session = factory.openSession();
		session.beginTransaction();
		User user = new User();
		user.setLoginName("admin");
		user.setPassword(DigestUtils.md5Hex("admin"));
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}
	
}
