package com.example;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class ResourceApplication extends WebSecurityConfigurerAdapter{
	
	@RequestMapping("/")
	@CrossOrigin(origins="*", maxAge=3600, allowedHeaders={"x-auth-token", "x-requested-with"})
	public Message home(){
		return new Message("Hello World");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic().disable();
		http.cors().and().authorizeRequests().anyRequest().authenticated();
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}
	
}

class Message {
	private String id = UUID.randomUUID().toString();
	private String content;
	
	public Message(){
		
	}
	
	public Message(String content){
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}