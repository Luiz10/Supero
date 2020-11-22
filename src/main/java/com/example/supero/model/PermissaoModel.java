package com.example.supero.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Setter;

import lombok.Getter;

@Relation(collectionRelation = "permissao")
@Getter
@Setter
public class PermissaoModel extends RepresentationModel<PermissaoModel>{

	private Long id;
	private String descricao;
}
