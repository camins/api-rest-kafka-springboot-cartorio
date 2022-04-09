package br.com.camila.cartorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.camila.cartorio.domain.Pessoa;
import br.com.camila.cartorio.domain.PessoaDTO;
import br.com.camila.cartorio.kafka.producer.CartorioProducer;
import br.com.camila.cartorio.service.PessoaService;

@RestController
@RequestMapping("/cartorio")
public class CartorioController {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private CartorioProducer cartorioProducer;
	
	@PostMapping
	public ResponseEntity<Pessoa> inserir(@RequestBody Pessoa pessoa) {
		
		Pessoa p = pessoaService.salvar(pessoa);
		
		PessoaDTO pessoaDTO = PessoaDTO.builder()
				.id(p.getId())
				.cidade(p.getCidade())
				.estado(p.getEstado())
			.build();
		
		cartorioProducer.send(pessoaDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
}
