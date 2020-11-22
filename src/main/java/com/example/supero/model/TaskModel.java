package com.example.supero.model;

import java.sql.Date;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "task")
@Getter
@Setter
public class TaskModel extends RepresentationModel<TaskModel>{

	private Long id;
	private String descricao;
	private String titulo;
	private Boolean status;
	private Date dataCriacao;
	private Date dataRemocao;
	private Date dataEdicao;
	private Date dataConclusao;
	private UsuarioModel usuarioModel;

}
