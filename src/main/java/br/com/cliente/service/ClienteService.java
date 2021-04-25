package br.com.cliente.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cliente.dto.input.ClienteInputDTO;
import br.com.cliente.dto.output.ClienteOutputDTO;
import br.com.cliente.mapper.ClienteMapper;
import br.com.cliente.models.Cliente;
import br.com.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteMapper clienteMapper;
	
	@Transactional
	public ClienteOutputDTO salvar(ClienteInputDTO clienteInput) {
		
		String cpf = clienteInput.getCpf();
		cpf = cpf.replace(".", "").replace("-", "");
		clienteInput.setCpf(cpf);		
		
		Cliente cliente = clienteMapper.converterInputDTOParaModel(clienteInput);
		
		LocalDateTime dataCriacao = LocalDateTime.now();		
		cliente.setDataCriacao( dataCriacao );
		
		String[] nomeCompleto = clienteInput.getNomeCompleto().split(" ");
		 
		cliente.setNome(nomeCompleto[0]);
		cliente.setSobrenome(nomeCompleto[1]);
		
		cliente = repository.save( cliente );
		
		return clienteMapper.converterModelParaOutputDTO( cliente );
	}

	public List<ClienteOutputDTO> buscarTodos() {
		return repository.findAll()
				.stream()
				.map(cliente -> clienteMapper.converterModelParaOutputDTO(cliente))
				.collect(Collectors.toList());
	}

	public Optional<Cliente> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public ClienteOutputDTO buscarId(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		
		return clienteMapper.converterModelParaOutputDTO( cliente.get() );
	}

	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);		
	}

	public List<Cliente> buscarPorNome(String nome) {	
		return repository.findByNome(nome);
	}

	@Transactional
	public ClienteOutputDTO atualizar(Cliente cliente, ClienteInputDTO clienteInput) {
		
		String cpf = clienteInput.getCpf();
		cpf = cpf.replace(".", "").replace("-", "");
		clienteInput.setCpf(cpf);		
		
		Cliente c = clienteMapper.converterInputDTOParaModel(clienteInput);
		
		LocalDateTime dataCriacao = LocalDateTime.now();		
		c.setDataCriacao( dataCriacao );		
		String[] nomeCompleto = clienteInput.getNomeCompleto().split(" ");		 
		c.setNome(nomeCompleto[0]);
		c.setSobrenome(nomeCompleto[1]);
		
		BeanUtils.copyProperties(c, cliente, "id");
		
		cliente = repository.save( cliente );
		
		return clienteMapper.converterModelParaOutputDTO( cliente );
	}

	
}
