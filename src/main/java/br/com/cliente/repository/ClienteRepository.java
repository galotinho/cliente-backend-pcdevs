package br.com.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cliente.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("from Cliente where nome like :nome%")
	List<Cliente> findByNome(String nome); //Hibernate que faz implementação de método
	
	@Query("from Cliente order by id DESC")
	List<Cliente> findAll(); //Hibernate que faz implementação de método
	
}
