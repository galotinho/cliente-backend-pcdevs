package br.com.cliente.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "qtd_paginas")
	private Integer quantidadePaginas;
	private Date dataPublicacao;
	private String nome;
	
//	@ManyToOne
//	@JoinColumn(name = "autor_id", nullable = false)
//	private Autor autor;	
	
	
	
}
