package com.suyog.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.suyog.spring.bean.Account;
import com.suyog.spring.constants.QueryConstants;

public class AccountDAOImpl implements AccountDAO{
	private DataSource datasource;
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	@Override
	public void insert(Account account) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = datasource.getConnection();
			ps = con.prepareStatement(QueryConstants.ACCOUNT_SAVE);
			ps.setInt(1, account.getAccno());
			ps.setString(2, account.getName());
			ps.setDouble(3, account.getBalance());
			int rowInserted = ps.executeUpdate();
			System.out.println("Number of Row Inserted"+rowInserted);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(con != null){
					con.close();
				}if(ps != null){
					ps.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}

		}

	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(QueryConstants.ACCOUNT_UPDATE);
			preparedStatement.setString(1, account.getName());
			preparedStatement.setDouble(2, account.getBalance());
			preparedStatement.setInt(3, account.getAccno());
			int rowUpdated = preparedStatement.executeUpdate();
			System.out.println("Number of Rows Updated :"+rowUpdated);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(connection != null){
					connection.close();
				}if(preparedStatement != null){
					preparedStatement.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(int accno) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		try{
			connection = datasource.getConnection();
			statement = connection.prepareStatement(QueryConstants.ACCOUNT_DELETE_BY_ACCNO);
			statement.setInt(1, accno);
			int rowDeleted = statement.executeUpdate();
			System.out.println("Number of row deleted"+rowDeleted);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(connection != null){
					connection.close();
				}if(statement != null){
					statement.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

	}

	@Override
	public Account findAccno(int accno) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Account account = null;
		try{
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(QueryConstants.ACCOUNT_FIND_BY_ACCNO);
			preparedStatement.setInt(1, accno);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				account = new Account();
				account.setAccno(resultSet.getInt("ACCNO"));
				account.setName(resultSet.getString("NAME"));
				account.setBalance(resultSet.getDouble("BALANCE"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(connection != null){
					connection.close();
				}
				if(preparedStatement != null){
					preparedStatement.close();
				}if (resultSet != null) {
					resultSet.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return account;
	}

	@Override
	public List<Account> findByName(String name) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Account> accountsList = new ArrayList<Account>();
		try{
			connection = datasource.getConnection();
			preparedStatement=connection.prepareStatement(QueryConstants.ACCOUNT_FIND_BY_NAME);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Account account = new Account();
				account.setAccno(resultSet.getInt("ACCNO"));
				account.setName(resultSet.getString("NAME"));
				account.setBalance(resultSet.getDouble("BALANCE"));
				accountsList.add(account);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(connection != null){
					connection.close();
				}if(preparedStatement!= null){
					preparedStatement.close();
				}if (resultSet != null) {
					resultSet.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return accountsList;
	}

	@Override
	public List<Account> findByBalance(double balance) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Account> accountsList = new ArrayList<Account>();
		try{
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(QueryConstants.ACCOUNT_FIND_BY_BALANCE);
			preparedStatement.setDouble(1, balance);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Account account = new Account();
				account.setAccno(resultSet.getInt("ACCNO"));
				account.setName(resultSet.getString("NAME"));
				account.setBalance(resultSet.getDouble("BALANCE"));
				accountsList.add(account);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(connection != null){
					connection.close();
				}if(preparedStatement != null){
					preparedStatement.close();
				}if (resultSet != null) {
					resultSet.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return accountsList;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Account> accountsList = new ArrayList<Account>();
		try{
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(QueryConstants.ACCOUNT_FIND_ALL);
			resultSet = preparedStatement.executeQuery();
			while(resultSet != null){
				Account account = new Account();
				account.setAccno(resultSet.getInt("ACCNO"));
				account.setName(resultSet.getString("NAME"));
				account.setBalance(resultSet.getDouble("BALANCE"));
				accountsList.add(account);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
			if(connection != null){
				connection.close();
			}if(preparedStatement != null){
				preparedStatement.close();
			 }if (resultSet != null) {
				resultSet.close();
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return accountsList;
	}

	@Override
	public int rowCount() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int rowCount = 0;
		try{
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(QueryConstants.ACCOUNT_ROW_COUNT);
			resultSet = preparedStatement.executeQuery();
		    if(resultSet.next()){
		    	rowCount = resultSet.getInt(1);
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(connection != null){
					connection.close();
				}if(preparedStatement != null){
					preparedStatement.close();
				}if(resultSet != null){
					resultSet.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return rowCount;
	}

}
