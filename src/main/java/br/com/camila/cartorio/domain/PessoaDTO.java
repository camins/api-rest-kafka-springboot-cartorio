package br.com.camila.cartorio.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaDTO {

	private Short id;
	private String cidade;
	private String estado;
}
