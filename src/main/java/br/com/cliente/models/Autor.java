package br.com.cliente.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer idade;
	
	@Column(name = "data_nascimento")
	private Date dataDeNascimento;
	
	@Column(nullable = false)
	private String nome;
	
//	@JsonIgnore
//	@JsonIgnoreProperties("autor")
//	@JsonIgnoreProperties({"autor","id"})
	//@OneToMany(mappedBy = "autor")
	//private List<Livro> livros;
	
	@ManyToMany
	@JoinTable(name = "autor_livro", 
			   joinColumns = @JoinColumn(name = "id_autor"),
			   inverseJoinColumns = @JoinColumn(name = "id_livro"))
	private List<Livro> livros = new ArrayList<>();	
	
}
