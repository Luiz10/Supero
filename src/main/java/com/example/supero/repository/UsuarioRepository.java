package com.example.supero.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.supero.entity.Usuario;

@Repository
public interface UsuarioRepository extends GenericRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);
	
}
