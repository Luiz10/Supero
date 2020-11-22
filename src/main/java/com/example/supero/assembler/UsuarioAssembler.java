package com.example.supero.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.example.supero.config.SuperoLink;
import com.example.supero.controller.UsuarioController;
import com.example.supero.entity.Usuario;
import com.example.supero.model.UsuarioModel;

@Component
public class UsuarioAssembler extends RepresentationModelAssemblerSupport<Usuario, UsuarioModel> {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	SuperoLink link;
	
	public UsuarioAssembler() {
		super(UsuarioController.class, UsuarioModel.class);
	}

	@Override
	public UsuarioModel toModel(Usuario usuario) {
		UsuarioModel usuarioModel = modelMapper.map(usuario, UsuarioModel.class);
		
		usuarioModel.add(link.salvaUsuario(usuario, "salva-usuario"));
		usuarioModel.add(link.pesquisaUsuario(usuario.getId(), "pesquisa-usuario"));
		
		return usuarioModel;
	}
	@Override
	public CollectionModel<UsuarioModel> toCollectionModel(Iterable<? extends Usuario> entities) {
		return super.toCollectionModel(entities)
				.add(link.listarUsuarios("listar-usuarios"));
	}

}
