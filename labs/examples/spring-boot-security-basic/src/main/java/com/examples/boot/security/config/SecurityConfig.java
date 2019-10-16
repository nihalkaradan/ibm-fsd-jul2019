package com.examples.boot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	// Authorize Requests	
				.authorizeRequests()
				// Allow greetings request w/o authentication
				.antMatchers("/greetings/**").permitAll()
				// Authenticate rest all requests
				.anyRequest().authenticated()
			.and()
				// Enables Basic Authentication to access from REST Client
				.httpBasic()
			.and()
				// Enables Form Authentication to access from browser
				 .formLogin();			
	}

}
