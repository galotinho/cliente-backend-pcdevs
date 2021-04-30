package br.com.cliente.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cliente.dto.input.ClienteInputDTO;
import br.com.cliente.dto.output.ClienteOutputDTO;
import br.com.cliente.models.Cliente;
import br.com.cliente.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<ClienteOutputDTO> buscarTodos() {	
		return service.buscarTodos();		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteOutputDTO> buscarPorId(@PathVariable Long id) {				
		
		ClienteOutputDTO clienteDTO = service.buscarId(id);
		
		if(!clienteDTO.equals(null)) {
			return ResponseEntity.ok( clienteDTO );
		}
		
		return ResponseEntity.notFound().build();
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteOutputDTO salvar(@RequestBody @Valid ClienteInputDTO clienteInput) {
		
		return service.salvar(clienteInput);
	
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteOutputDTO> atualizar(@RequestBody ClienteInputDTO clienteInput, @PathVariable Long id) {
		
		Optional<Cliente> cli = service.buscarPorId( id );
		
		if( cli.isPresent() ) {
			return ResponseEntity.ok( service.atualizar( cli.get(), clienteInput ) );
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> excluir(@PathVariable Long id) {
		
		Optional<Cliente> cli = service.buscarPorId( id );
		
		if(cli.isPresent()) {
			service.excluir(id);
			return 	ResponseEntity.noContent().build();		
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping("/buscar-por-nome")
	public List<Cliente> buscarPorNome(@RequestParam String nome){
		return service.buscarPorNome(nome);
	}
	
}
