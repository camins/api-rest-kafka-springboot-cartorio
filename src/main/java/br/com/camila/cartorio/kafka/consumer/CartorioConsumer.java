package br.com.camila.cartorio.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.camila.cartorio.domain.ReplyCpfDTO;
import br.com.camila.cartorio.service.PessoaService;

@Service
public class CartorioConsumer {
	
	@Autowired
	private PessoaService pessoaService;

	@KafkaListener(topics = "${topic.name.consumer}", 
			groupId = "${spring.kafka.consumer.group-id}",
			containerFactory = "kafkaListenerContainerFactory")
	public void consumer(ReplyCpfDTO reply) {
		pessoaService.buscarPessoaByIdAndUpdate(reply);;
	}
}
