package com.example.supero.exceptions;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Problema implements Serializable{


	private static final long serialVersionUID = 1L;
	private String message;
	private Date data;
	private int status;
	private Throwable excecao;
}
