package br.com.camila.cartorio.domain;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PessoaTests {

	@Test
	public void criar() {
		Pessoa p = new Pessoa();
		p.setId(Short.valueOf("1"));
		p.setNome("Heitor Santos Nóbrega");
		p.setCidade("Natal");
		p.setEstado("RN");
		p.setSexo("Masculino");
		p.setDataNascimento(LocalDateTime.of(2021, 11, 7, 7, 52));
		
	}
}
