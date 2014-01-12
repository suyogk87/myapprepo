package com.suyog.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suyog.spring.bean.Account;
import com.suyog.spring.dao.AccountDAO;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		accountDAO.insert(account);
		
	}

	@Override
	public void modify(Account account) {
		// TODO Auto-generated method stub
		accountDAO.update(account);
		
	}

	@Override
	public void remove(int accno) {
		// TODO Auto-generated method stub
		accountDAO.delete(accno);
		
	}

	@Override
	public Account geByAccno(int accno) {
		// TODO Auto-generated method stub
			return accountDAO.findByAccno(accno);
	}

	@Override
	public List<Account> getByName(String name) {
		// TODO Auto-generated method stub
		return accountDAO.findByName(name);
	}

	@Override
	public List<Account> getByBalance(double balance) {
		// TODO Auto-generated method stub
		return accountDAO.findByBalance(balance);
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return accountDAO.findAll();
	}

	@Override
	public int rowCount() {
		// TODO Auto-generated method stub
		return accountDAO.rowCount();
	}
	
	
}
