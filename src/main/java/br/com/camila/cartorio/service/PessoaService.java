package br.com.camila.cartorio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camila.cartorio.domain.Pessoa;
import br.com.camila.cartorio.domain.ReplyCpfDTO;
import br.com.camila.cartorio.exception.RecursoNaoEncontradoException;
import br.com.camila.cartorio.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa buscarPessoaById(Short id) {
		Optional<Pessoa> result = pessoaRepository.findById(id);
		
		if(result.isEmpty()) {
			throw new RecursoNaoEncontradoException();
		}
		
		return result.get();
	}
	
	public void buscarPessoaByIdAndUpdate(ReplyCpfDTO p) {
		Optional<Pessoa> result = pessoaRepository.findById(p.getId());
		
		if(result.isPresent()) {
			result.get().setCpf(p.getCpf());
			salvar(result.get());
		}
	}
	
	public List<Pessoa> listar(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
}
