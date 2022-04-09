package br.com.camila.cartorio.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.camila.cartorio.domain.PessoaDTO;

@Service
public class CartorioProducer {

	private static final Logger logger = LoggerFactory.getLogger(CartorioProducer.class); 
	private final String topic;
	private final KafkaTemplate<String, PessoaDTO> kafkaTemplate;
	
	public CartorioProducer(@Value("${topic.name.producer}") String topic, KafkaTemplate<String, PessoaDTO> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(PessoaDTO pessoa) {
		kafkaTemplate.send(topic, pessoa).addCallback(
				success -> logger.info("Pessoa "+ pessoa.getId()+" enviada, aguardando o retorno com o cpf. " +success.getProducerRecord().value()),
				failure -> logger.info("Pessoa "+ pessoa.getId()+" não enviada. " + failure.getMessage())
				);
	}
}
