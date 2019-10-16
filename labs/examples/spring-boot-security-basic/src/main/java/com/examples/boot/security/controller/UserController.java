package com.examples.boot.security.controller;

import java.security.Principal;

import javax.annotation.security.PermitAll;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
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
