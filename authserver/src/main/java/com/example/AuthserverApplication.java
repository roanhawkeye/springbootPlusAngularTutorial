package com.example;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAuthorizationServer
@RestController
@EnableResourceServer
public class AuthserverApplication extends WebMvcConfigurerAdapter {
	
	@RequestMapping("/user")
	public Principal user(Principal user){
		return user;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AuthserverApplication.class, args);
	}
}
