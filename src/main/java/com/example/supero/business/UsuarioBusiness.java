package com.example.supero.business;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supero.entity.Usuario;
import com.example.supero.repository.UsuarioRepository;

@Service
public class UsuarioBusiness implements Serializable{

	private static final long serialVersionUID = 1L;

	UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioBusiness(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario salvaUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscaUsurio(Long idUsuario) {
		return this.usuarioRepository.getOne(idUsuario);
	}
	
	public List<Usuario> listarUsuairio(){
		return usuarioRepository.findAll();
	}
	
}
