package br.com.camila.cartorio.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String cidade;
	
	@Column(length = 10, nullable = false)
	private String estado;
	
	@Column(length = 10, nullable = false)
	private String sexo;
	
	@Column(nullable = true, unique = true)
	private String cpf;
	
	@Column
	private LocalDateTime dataNascimento;
	
}
