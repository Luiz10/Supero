package com.example.supero.config;

import java.io.Serializable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class SessionUtil implements Serializable{

	private static final long serialVersionUID = 1L;

	public Authentication getPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (Authentication) authentication.getPrincipal();
	}
	
	public Long idUsuario() {
		Jwt jwt = (Jwt) getPrincipal();
		return jwt.getClaim("id_usuario");
	}
}
