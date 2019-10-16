package com.examples.boot.security;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.examples.boot.security.model.UserAccount;
import com.examples.boot.security.repo.UserRepository;

@SpringBootApplication
public class BasicSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BasicSecurityApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(UserRepository userRepository) {
//		return args -> Stream.of("user1,{noop}password1", "user2,{noop}password2")
//						.map(u -> u.split(","))
//						.forEach(t -> userRepository.save(new UserAccount(t[0],t[1],true)));
//	}

	@Override
	public void run(String... args) throws Exception {
//		Stream.of("admin,{noop}admin", "user1,{noop}user1")
//						.map(u -> u.split(","))
//						.forEach(t -> userRepository.save(new UserAccount(t[0],t[1],true)));
		
		userRepository.save(new UserAccount("admin","{noop}admin",true));
		userRepository.save(new UserAccount("user1","{noop}user1",true));
		
		System.out.println(userRepository.findAll());
	}
}

