package com.example.supero.model;

import java.sql.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "usuario")
public class UsuarioModel extends RepresentationModel<UsuarioModel> {

	private Long id;
	private String username;
	private String senha;
	private Date dataCadastro;
	private List<TaskModel>tasksModel;
	private List<PermissaoModel> permissoesModel;
}
