package br.com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cliente.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
