package com.example.supero.mixin;

import lombok.Setter;

import java.io.Serializable;

import lombok.Getter;

@Getter
@Setter
public class PermissaoMixin implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
}
