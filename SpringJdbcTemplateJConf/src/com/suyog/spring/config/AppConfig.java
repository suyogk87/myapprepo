package com.suyog.spring.config;

import org.springframework.beans.factory.annotation.Value;

public class AppConfig {
@Value("${oracle.username}")	
private String username;

private String password;

private String url;

private String driverClass;

private int initialSize;

private int maxSize;
}
