package br.com.cliente.dto.output;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteOutputDTO {

	private Long id;
	private String nome;
	private String rg;
	private String cpf;
	private String sobrenome;
	private String telefone;
	private LocalDateTime dataCriacao;
}
