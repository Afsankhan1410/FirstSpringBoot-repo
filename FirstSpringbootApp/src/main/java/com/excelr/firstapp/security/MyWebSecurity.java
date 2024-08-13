package com.excelr.firstapp.security;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyWebSecurity extends WebSecurityConfigurerAdapter
{
	
//Authentication
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception 
{
		auth.inMemoryAuthentication()
		.withUser("Alice")
		.password("Alice123")		
		.authorities("ADMIN")
		.and()
		.withUser("Ben")
		.password("Ben123")		
		.authorities("USER");

}

//Authorisation
@Override
protected void configure(HttpSecurity http) throws Exception 
{
    http.authorizeRequests()
    .antMatchers("/home","/addStudentForm","/403").hasAnyAuthority("USER","ADMIN")
    .antMatchers("/deletestudent/**","/updatestudentform/**").hasAuthority("ADMIN")
    .anyRequest().authenticated()
    .and()
    .formLogin().loginProcessingUrl("/login").successForwardUrl("/home").permitAll()
    .and()
    .logout().logoutSuccessUrl("/login").permitAll()
    .and()
    .exceptionHandling().accessDeniedPage("/403")
    .and()
    .cors().and().csrf().disable();

}

@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

}
