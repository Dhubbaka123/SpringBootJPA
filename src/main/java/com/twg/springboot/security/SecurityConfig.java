package com.twg.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager configureInMemoryUsers() {
		
		UserDetails user1 = User.builder().username("twguser1").password("{noop}twg1").roles("ADMIN").build();
		UserDetails user2 = User.builder().username("twguser2").password("{noop}twg2").roles("MANAGER").build();
		UserDetails user3 = User.builder().username("twguser3").password("{noop}twg3").roles("EMPLOYEE").build();
		
		InMemoryUserDetailsManager inMemoryUserDetails = new InMemoryUserDetailsManager(user1,user2,user3);
		
		System.out.println("update in jpa_features branch at 3:53");
		
		return inMemoryUserDetails;
		
	}
}
