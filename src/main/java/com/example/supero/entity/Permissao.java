package com.example.supero.entity;

import java.io.Serializable;

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
@Table(name = "TB_PERMISSAO")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permissao implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_PERMISSAO")
	@SequenceGenerator(allocationSize = 0,name = "SEQ_PERMISSAO",sequenceName = "SEQ_PERMISSAO")
	@Column(name = "CD_PERMISSAO",nullable = false)
	@ToString.Include
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "DS_PERMISSAO",nullable = false,length = 120)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="CD_USUARIO",referencedColumnName = "CD_USUARIO")
	private Usuario usuario;
}
