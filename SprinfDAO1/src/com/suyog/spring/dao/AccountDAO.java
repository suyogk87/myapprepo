package com.suyog.spring.dao;

import java.util.List;

import com.suyog.spring.bean.Account;

public interface AccountDAO {
	public void insert(Account account);
	
	public void update(Account account);
	
	public void delete(int accno);
	
	public Account findAccno(int accno);
	
	public List<Account> findByName(String name);
	
	public List<Account> findByBalance(double balance);
	
	public List<Account> findAll();
	
	public int rowCount();

}
