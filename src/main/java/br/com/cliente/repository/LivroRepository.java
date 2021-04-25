package br.com.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cliente.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
