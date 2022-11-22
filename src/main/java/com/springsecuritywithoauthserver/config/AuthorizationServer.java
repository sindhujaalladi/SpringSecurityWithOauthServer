package com.springsecuritywithoauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	
	
	// Assuming client has registered with this our authorization server and mentioned their client id and secret values.
	 @Override 
	public void configure(ClientDetailsServiceConfigurer client) throws Exception {
		/*
		 * client.inMemory().withClient("client1")
		 * .secret(passwordEncoder.encode("oauthsecret1")). 
		 * scopes("read")
		 * .redirectUris("http://localhost:1000/login")
		 * .authorizedGrantTypes("password", "authorization_code", "refresh_token")
		 * //.authorizedGrantTypes("authorization_code")
		 * .accessTokenValiditySeconds(3600);
		 */
		 
		 
		 client.inMemory()
		 .withClient("client1")
		  .secret(passwordEncoder.encode("oauthsecret1"))
		.scopes("read")
		.authorizedGrantTypes("password")
		.and().withClient("client2")
		  .secret(passwordEncoder.encode("oauthsecret2"))
		.scopes("read")
		.authorizedGrantTypes("authorization_code")
		.redirectUris("http://localhost:1000");
	}
	
	
	 @Override 
	   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception { 
	      endpoints.authenticationManager(authenticationManager); 
	   } 
	
	
	//Spring security oauth exposes two endpoints for checking tokens (/oauth/check_token and /oauth/token_key) which are by default protected behind denyAll(). 
	 //tokenKeyAccess() and checkTokenAccess() methods open these endpoints for use.
	 	@Override
	    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	        security
	            .tokenKeyAccess("permitAll()")
	            .checkTokenAccess("isAuthenticated()")
	            .allowFormAuthenticationForClients();
	    }
	
	
}
