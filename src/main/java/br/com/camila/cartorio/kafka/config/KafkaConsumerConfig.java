package br.com.camila.cartorio.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import br.com.camila.cartorio.domain.ReplyCpfDTO;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	@Value(value = "${spring.kafka.producer.bootstrap-servers}")
	private String bootstrapAdress;

	@Value(value = "${topic.name.consumer}")
	private String topic;

	@Value(value = "${spring.kafka.consumer.group-id}")
	private String group;

	@Bean
	public ConsumerFactory<String, ReplyCpfDTO> cartorioConsumerFactory() {
		
		JsonDeserializer<ReplyCpfDTO> deserializer = new JsonDeserializer<>(ReplyCpfDTO.class);
	    deserializer.setRemoveTypeHeaders(false);
	    deserializer.addTrustedPackages("*");
	    deserializer.setUseTypeMapperForKey(true);
		
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAdress);
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG, group);
		return new DefaultKafkaConsumerFactory<>(
				configProps,
				new StringDeserializer(),
				deserializer);
	}

	@Bean
	KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, ReplyCpfDTO>>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ReplyCpfDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(cartorioConsumerFactory());
        return factory;
    }
}
