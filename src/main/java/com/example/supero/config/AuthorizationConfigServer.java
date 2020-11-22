package com.example.supero.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfigServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	private JpaUserDetails jpaDetails;
	
	@Autowired
	private PasswordEncoder enconder;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	    TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
	    enhancerChain.setTokenEnhancers(Arrays.asList(new CustomTokenEncherer(),jwtAccessTokenConverter()));
		endpoints.accessTokenConverter(jwtAccessTokenConverter()).authenticationManager(authenticationManager)
				.userDetailsService(jpaDetails).reuseRefreshTokens(true)
				.tokenEnhancer(enhancerChain);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("isAutenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("user").secret(enconder.encode("senha")).accessTokenValiditySeconds(16000)
				.authorizedGrantTypes("password", "authorization_code").refreshTokenValiditySeconds(16000)
				.scopes("READ", "WRITE");
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("5a5e9068687419c65ba8fe9f934501e1");
		return accessTokenConverter;
	}

	
}
