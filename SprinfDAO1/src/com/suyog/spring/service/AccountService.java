package com.suyog.spring.service;

import java.util.List;

import com.suyog.spring.bean.Account;

public interface AccountService {
	
public void save(Account account);
public void modify(Account account);
public void remove(int accno);
public Account geByAccno(int accno);
public List<Account> getByName(String name);
public List<Account> getByBalance(double balance);
public List<Account> getAll();
public int rowCount();

}
