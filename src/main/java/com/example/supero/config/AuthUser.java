package com.example.supero.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.supero.entity.Usuario;

import lombok.Getter;

@Getter
public class AuthUser extends User {

	private static final long serialVersionUID = 1L;

	private Long id;

	public AuthUser(Usuario usuario) {
		super(usuario.getUsername(), usuario.getSenha(), getAuthorities(usuario));

		this.id = usuario.getId();
	}
	
   public static Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario){
	   return usuario.getPermissoes().stream()
			   .map(permissao -> new SimpleGrantedAuthority(permissao.getDescricao()))
			   .collect(Collectors.toList());
					   
   }
	
}
