package br.com.camila.cartorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.camila.cartorio.domain.Pessoa;
import br.com.camila.cartorio.exception.RecursoNaoEncontradoException;
import br.com.camila.cartorio.service.PessoaService;

@RestController
@RequestMapping("pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> listar(){
		return pessoaService.listar();
	}
	
	@GetMapping("/{id}")
	public Pessoa buscar(@PathVariable Short id) {
		try {
			return pessoaService.buscarPessoaById(id);
		} catch (RecursoNaoEncontradoException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada", e);
		}
	}
}
