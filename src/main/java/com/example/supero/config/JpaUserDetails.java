package com.example.supero.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.supero.entity.Usuario;
import com.example.supero.i18n.SuperoI18N;
import com.example.supero.repository.UsuarioRepository;

@Service
public class JpaUserDetails implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	MessageSource messageSource;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(messageSource.getMessage("500", null,
						SuperoI18N.USUARIO_SENHA_NAO_ENCONTRADO, LocaleContextHolder.getLocale())));
		return new AuthUser(usuario);
	}
		
	
	

}
