package com.example.supero.enums;

import lombok.Getter;

@Getter
public enum EnumStatus {

	CONLUIDO(1L,"CONCLUIDO"),
	EM_ANDAMENTO(0L,"EM ANDAMENTO");
	
	private Long id;
	private String  descricao;
	
	EnumStatus(Long id,String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
}
