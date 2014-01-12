package com.suyog.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suyog.spring.service.AccountService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		AccountService accountService = context.getBean("accountService",AccountService.class); 
		
	}
	private static void sop(Object object){
		System.out.println(object);
	}

}
