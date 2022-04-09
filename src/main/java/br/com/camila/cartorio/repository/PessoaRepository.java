package br.com.camila.cartorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.camila.cartorio.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Short> {

}
