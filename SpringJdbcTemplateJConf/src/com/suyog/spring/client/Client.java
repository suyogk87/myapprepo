package com.suyog.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suyog.spring.bean.Account;
import com.suyog.spring.dao.AccountDAOImpl;
import com.suyog.spring.service.AccountService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		AccountService accountService = context.getBean("accountService",AccountService.class); 
		System.out.println("Connection"+AccountDAOImpl.class);
		/*Account account = new Account();*/
		/*INSERT CODE GOES HERE*/
		/*account.setAccno(1004);
		account.setName("Suyog");
		account.setBalance(10000);
		accountService.save(account);*/
		
		/*UPDATE CODE GOES HERE*/
		/*account.setAccno(1004);
		account.setName("Suyog");
		account.setBalance(50000);
		accountService.modify(account);*/
		
		/*DELETE CODE GOES HERE*/
		/*accountService.remove(1001);*/
		
		/*FIND BY ACCOUNT NO CODE GOES HERE*/
		/*account=accountService.geByAccno(1004);
		sop("Accno : "+account.getAccno());
		sop("AccName : "+account.getName());
		sop("Balance : "+account.getBalance());*/
		
		/*FIND BY ACCOUNT NAME CODE GOES HERE*/
		/*List<Account> accountList = accountService.getByName("suyog");
		for(Account account2 : accountList){
			sop("Accno : "+account2.getAccno());
			sop("AccName : "+account2.getName());
			sop("Balance : "+account2.getBalance());
		}*/
		
		/*FIND BY ACCOUNT BALANCE CODE GOES HERE*/
		/*List<Account> accountList2 = accountService.getByBalance(6200);
		for(Account account2 : accountList2){
			sop("Accno : "+account2.getAccno());
			sop("AccName : "+account2.getName());
			sop("Balance : "+account2.getBalance());
		}*/
		/*FIND BY ALL CODE GOES HERE*/
		List<Account> accountList2 = accountService.getAll();
		for(Account account2 : accountList2){
			sop("Accno : "+account2.getAccno());
			sop("AccName : "+account2.getName());
			sop("Balance : "+account2.getBalance());
		}
		int rowCount  = accountService.rowCount();
		sop("No OF ROWS IN THE ACCOUNT TABLE :...>"+rowCount);
	}
	private static void sop(Object object){
		System.out.println(object);
	}

}
