package br.com.camila.cartorio.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.camila.cartorio.domain.Pessoa;

@SpringBootTest
public class PessoaRepositoryTests {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Test
	public void inserir() {
		Pessoa p1 = new Pessoa();
		p1.setNome("Heitor Santos Nóbrega");
		p1.setCidade("Natal");
		p1.setEstado("RN");
		p1.setSexo("Masculino");
		p1.setDataNascimento(LocalDateTime.of(2021, 11, 7, 7, 52));
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Camila Nascimento dos Santos");
		p2.setCidade("Natal");
		p2.setEstado("RN");
		p2.setSexo("Feminino");
		p2.setDataNascimento(LocalDateTime.of(1992, 5, 20, 20, 45));
		
		pessoaRepository.save(p1);
		pessoaRepository.save(p2);
	}
}
