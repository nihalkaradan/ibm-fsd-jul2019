package com.examples.boot.security.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/")
	@CrossOrigin("*")
	public String home() {
		return "Spring Security (Basic) Demo Service!";
	}
	
	@RequestMapping("/greetings")
	@CrossOrigin("*")
	public String greetings() {
		return "Hey! Welcome to Spring Security Training";
	}
	
	@RequestMapping("/user")
	@CrossOrigin("*")
	public Principal user(Principal user) {
		return user;
	}
	
}
