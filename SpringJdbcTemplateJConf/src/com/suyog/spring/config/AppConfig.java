package com.suyog.spring.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp.BasicDataSource;

import com.suyog.spring.bean.Account;
import com.suyog.spring.dao.AccountDAO;
import com.suyog.spring.dao.AccountDAOImpl;
import com.suyog.spring.service.AccountService;
import com.suyog.spring.service.AccountServiceImpl;

@Configuration
public class AppConfig {

	@Value("${oracle.username}")	
	private String username;

	@Value("${oracle.password}")
	private String password;

	@Value("${oracle.url}")
	private String url;

	@Value("${oracle.driverClass}")
	private String driverClass;

	@Value("${oracle.initialSize}")
	private int initialSize;

	@Value("$(oracle.maxSize)")
	private int maxSize;

	@Bean
	public static PropertyPlaceholderConfigurer externalropertiesConfigurer(){
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[]{new ClassPathResource("com/suyog/spring/properties/dbproperties.properties")};
		configurer.setLocations(resources);
		configurer.setIgnoreUnresolvablePlaceholders(true);
		return configurer;
	}
	public @Bean
	DataSource dataSource(){
		BasicDataSource apacheDS = new BasicDataSource();
		apacheDS.setDriverClassName(driverClass);
		apacheDS.setUrl(url);
		apacheDS.setUsername(username);
		apacheDS.setPassword(password);
		apacheDS.setInitialSize(initialSize);
		apacheDS.setMaxWait(maxSize);
		return apacheDS;

	}
	public @Bean
	JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource()); 
	}
	public @Bean
	AccountDAO accountDAO(){
		return new AccountDAOImpl();

	}
	
	public @Bean
	AccountService accountService(){
		return new AccountServiceImpl();
		
	}

}
