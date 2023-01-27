package com.example.logintest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.logintest")
public class LoginTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginTestApplication.class, args);
	}

}
