package com.example;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ResourceApplication {
	
	@RequestMapping("/")
	public Message home(){
		return new Message("Hello World");
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