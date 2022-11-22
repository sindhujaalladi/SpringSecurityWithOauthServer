package com.springsecuritywithoauthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter{
	


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/employee/**").authenticated().antMatchers("/").permitAll();
               // .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

}
