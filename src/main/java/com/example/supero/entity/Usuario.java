package com.example.supero.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Table(name="TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_USUARIO")
	@SequenceGenerator(allocationSize = 0,name = "SEQ_USUARIO",sequenceName = "SEQ_USUARIO")
	@Column(name = "CD_USUARIO",nullable = false)
	@ToString.Include
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "SENHA",nullable = false)
	private String senha;
	
	@Column(name = "NM_USERNAME",nullable = false)
	private String username;
	
	@Column(name = "DT_CADASTRO",nullable = false)
	private Date dataCadastro;
	
	
	@OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER )
	private List<Permissao> permissoes;
	
	@OneToMany(mappedBy = "usuario")
	private List<Task> tasks;
	
}
