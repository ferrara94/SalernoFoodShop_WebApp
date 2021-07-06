package com.develop.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	private final PasswordEncoder passwordEncoder;
			
	@Autowired
	public WebSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			http
				.authorizeRequests()
					.antMatchers("/", "/styles/**", "/images/**").permitAll()
					.antMatchers("/customers/**").hasRole(ApplicationUserRole.ADMIN.name())
					.anyRequest().authenticated()
				.and()
				.formLogin()
					.permitAll()
				;
		
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails customerMax = User.builder()
							.username("Max")
							.password(passwordEncoder.encode("sa"))
							.roles(ApplicationUserRole.CUSTOMER.name())
							.build()
				;
		
		UserDetails adminJosh = User.builder()
							.username("Josh")
							.password(passwordEncoder.encode("sa"))
							.roles(ApplicationUserRole.ADMIN.name())
							.build()
					;
		
		
		
		return new InMemoryUserDetailsManager(
				customerMax,
				adminJosh
			);
	}
	
	

	
	
}
