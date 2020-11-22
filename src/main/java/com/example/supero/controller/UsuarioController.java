package com.example.supero.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.supero.assembler.UsuarioAssembler;
import com.example.supero.business.UsuarioBusiness;
import com.example.supero.entity.Usuario;
import com.example.supero.model.UsuarioModel;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	UsuarioAssembler usuarioAssembler;

	@Autowired
	UsuarioBusiness usuarioBusiness;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<UsuarioModel> salvaUsuario(@RequestBody Usuario usuario){
	   Usuario user = 	usuarioBusiness.salvaUsuario(usuario);
	   return ResponseEntity.ok().body(usuarioAssembler.toModel(user));	
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/{idUsuario}")
	public ResponseEntity<UsuarioModel> pesquisarUsuarioId(@PathVariable Long idUsuario){
		Usuario usuario = usuarioBusiness.buscaUsurio(idUsuario);
		return ResponseEntity.ok(usuarioAssembler.toModel(usuario));
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public ResponseEntity<CollectionModel<UsuarioModel>> listaUsuarios(){
		List<Usuario> usuario = usuarioBusiness.listarUsuairio();
		return ResponseEntity.ok(usuarioAssembler.toCollectionModel(usuario));
	}
}

