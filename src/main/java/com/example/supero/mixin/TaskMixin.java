package com.example.supero.mixin;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskMixin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	private String titulo;
	private String status;
	private Date dataCriacao;
	private Date dataRemocao;
	private Date dataEdicao;
	private Date dataConclusao;
	private UsuarioMixin usuario;

}
