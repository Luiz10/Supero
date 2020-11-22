package com.example.supero.mixin;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.example.supero.entity.Permissao;
import com.example.supero.entity.Task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioMixin implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String senha;
	private String username;
	private Date dataCadastro;
	private List<Permissao> permissoes;
	private List<Task> tasks;
}
