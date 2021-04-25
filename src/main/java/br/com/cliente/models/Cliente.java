package br.com.cliente.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	@Column
	private String sobrenome;
	
	@Column(name = "cpf", length = 15, nullable = false)
	private String cpf;

	private String rg;
	
	private String telefone;	
	
	private LocalDateTime dataCriacao;
	
}
