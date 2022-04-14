package com.cihatturhan.busseatreservation.com.main.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from user where username=?")
		.authoritiesByUsernameQuery("select username, role from role where username=?");
		/*
		auth.inMemoryAuthentication().withUser("John").password("admin").roles("ADMIN", "EMPLOYEE").and()
				.withUser("Eric").password("employee").roles("EMPLOYEE").and().withUser("Micheal").password("client")
				.roles("CLIENT");
	*/
		 
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/login","/test")
			.permitAll()
		.and()
			.formLogin()
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.permitAll();
		/*	
		.hasAnyRole("EMPLOYEE")
		.antMatchers("/deleteTour")
		.hasAnyRole("ADMIN")
		.antMatchers("/addComment", "/addUserToTour")
		.hasAnyRole("CLIENT")
				.and()
				.formLogin()
				.loginPage("/login.html")
				.permitAll()
				.and()
				.logout()
				.permitAll();
				
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/checkUserAccount")
				.defaultSuccessUrl("/")
				.permitAll()
				
			*/

	}
}
