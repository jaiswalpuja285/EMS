package com.code.spring.EMS.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("puja").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("akansha").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("siddartha").password("test123").roles("EMPLOYEE"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
//			.antMatchers("/employees/showForm*").hasAnyRole("MANAGER", "ADMIN")
//			.antMatchers("/employees/save*").hasAnyRole("MANAGER", "ADMIN")
//			.antMatchers("/employees/delete").hasRole("ADMIN")
//			.antMatchers("/employees/**").hasRole("EMPLOYEE")
//			.antMatchers("/resources/**").permitAll()
		    .anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
		
}

