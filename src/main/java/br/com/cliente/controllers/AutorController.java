package br.com.cliente.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cliente.dto.input.ClienteInputDTO;
import br.com.cliente.dto.output.ClienteOutputDTO;
import br.com.cliente.models.Autor;
import br.com.cliente.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository repository;
	
	@GetMapping
	public List<Autor> buscarTodos(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Autor salvar(@RequestBody Autor autor) {
		
		return repository.save(autor);
	
	}
}
