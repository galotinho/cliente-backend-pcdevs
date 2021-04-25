package br.com.cliente.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteInputDTO {

	private String nomeCompleto;
	@NotBlank
	@NotNull
	private String cpf;
	@NotNull
	private String rg;
	private String telefone;
}
