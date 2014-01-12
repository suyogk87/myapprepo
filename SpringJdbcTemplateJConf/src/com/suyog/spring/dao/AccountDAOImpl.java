package com.suyog.spring.dao;


import java.sql.Types;
import java.util.List;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.suyog.spring.bean.Account;
import com.suyog.spring.constants.QueryConstants;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO{
@Autowired
private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

	@Override
	public void insert(Account account) {
		// TODO Auto-generated method stub
		int rowInserted = jdbcTemplate.update(QueryConstants.ACCOUNT_SAVE,
		new Object[] {
				account.getAccno(),account.getName(),account.getBalance()
		},new int[]{Types.INTEGER, Types.VARCHAR, Types.DOUBLE});
		sop("NUMBER OF ROW INSERTED :....>"+rowInserted);
	}


	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		int rowUpdated = jdbcTemplate.update(QueryConstants.ACCOUNT_UPDATE,
				account.getAccno(),account.getName(),account.getBalance());
		sop("NUMBER OF ROW UPDATED :....>"+rowUpdated);
		
	}

	@Override
	public void delete(int accno) {
		// TODO Auto-generated method stub
		int rowDeleted = jdbcTemplate.update(QueryConstants.ACCOUNT_DELETE_BY_ACCNO,
				new Object[]{accno}, new int[]{Types.INTEGER});
		sop("NUMBER OF ROW DELETED :....>"+rowDeleted);
		
	}

	@Override
	public Account findByAccno(int accno) {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.queryForObject(QueryConstants.ACCOUNT_FIND_BY_ACCNO, new Object[]{accno}, new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findByName(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(QueryConstants.ACCOUNT_FIND_BY_NAME, new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findByBalance(double balance) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(QueryConstants.ACCOUNT_FIND_BY_BALANCE, new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(QueryConstants.ACCOUNT_FIND_ALL, new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public int rowCount() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForInt(QueryConstants.ACCOUNT_ROW_COUNT);
	}
	private static void sop(Object object){
		System.out.println(object);
	}
	
}
