package com.examples.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examples.boot.security.model.UserAccount;
import com.examples.boot.security.repo.UserRepository;

@SpringBootApplication
public class BasicSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BasicSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userRepository.save(new UserAccount("admin","{noop}admin",true));
		userRepository.save(new UserAccount("user1","{noop}user1",true));
		
		System.out.println(userRepository.findAll());
	}
}

