package com.develop.webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			http
				.authorizeRequests()
					.antMatchers("/", "/styles/**", "/images/**").permitAll()
					.anyRequest().authenticated()
				.and()
				.formLogin()
					.permitAll()
				;
		
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails user = User.withDefaultPasswordEncoder()
							.username("max")
							.password("sa")
							.roles("USER")
							.build()
				;
		
		return new InMemoryUserDetailsManager(user);
	}
	
	

	
	
}
