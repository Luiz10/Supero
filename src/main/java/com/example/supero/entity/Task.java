package com.example.supero.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@Table(name = "TB_TASK")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_TASK")
	@SequenceGenerator(allocationSize = 0,name = "SEQ_TASK",sequenceName = "SEQ_TASK")
	@Column(name = "CD_TASK",nullable = false)
	@ToString.Include
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "DESCRICAO_TASK",nullable = false,length = 120)
	private String descricao;
	
	@Column(name = "TITULO_TASK",nullable = false,length = 120)
	private String titulo;
	
	@Column(name = "STATUS_TASK",nullable = false)
	private String status;
	
	@Column(name = "DT_CRIACAO_TASK",nullable = false)
	private Date dataCriacao;
	
	@Column(name = "DT_REMOCAO_TASK",nullable = true)
	private Date dataRemocao;
	
	@Column(name = "DT_EDICAO_TASK",nullable = true)
	private Date dataEdicao;
	
	@Column(name = "DT_CONCLUSAO_TASK",nullable = true)
	private Date dataConclusao;
	
	@ManyToOne
	@JoinColumn(name="CD_USUARIO",referencedColumnName = "CD_USUARIO")
	private Usuario usuario;
}
