package com.springsecuritywithoauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springsecuritywithoauthserver.service.EmployeeInfoUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private EmployeeInfoUserDetailsService employeeInfoUserDetailsService;
		
	@Override 
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(employeeInfoUserDetailsService).passwordEncoder(passwordEncoder());
		   auth.inMemoryAuthentication().withUser("sindhu")
		   .password(passwordEncoder().encode("secret")).roles("ADMIN");
          // .withUser("sindhu").password(passwordEncoder.encode("secret"))
           //.roles("USER");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        	.antMatcher("/**")
	        	.authorizeRequests()
	        	.antMatchers("/oauth/authorize**", "/login**", "/error**")
	        	.permitAll()
        	.and()
            	.authorizeRequests()
            	.anyRequest().authenticated()
        	.and()
        		.formLogin().permitAll();
    	http.formLogin();
    	
    	http.csrf().disable();
    }

}
