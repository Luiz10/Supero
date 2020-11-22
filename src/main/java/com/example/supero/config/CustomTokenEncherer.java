package com.example.supero.config;

import java.util.HashMap;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class CustomTokenEncherer implements TokenEnhancer{

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		AuthUser authUser =  (AuthUser) authentication.getPrincipal();
		
		HashMap<String, Object> hashMap= new HashMap<>();
		hashMap.put("id_usuario", authUser.getId());
		
		DefaultOAuth2AccessToken defaultOAuth2AccessToken= (DefaultOAuth2AccessToken) accessToken;
		defaultOAuth2AccessToken.setAdditionalInformation(hashMap); 
		
		return accessToken;
	}

}
