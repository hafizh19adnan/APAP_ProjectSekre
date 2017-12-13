package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().
		antMatchers("/").permitAll().antMatchers("/css/*").permitAll().antMatchers("/api/*").permitAll().antMatchers("/img/*").permitAll().antMatchers("/js/*").permitAll().anyRequest().authenticated().and().formLogin().
		loginPage("/login").permitAll().and().logout().permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println("called");
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username, password, '1', id_univ, id_fakultas from user where username=?")
		.authoritiesByUsernameQuery("select username, 'ROLE-USER' from user where username = ?");
		
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");

	}
}
