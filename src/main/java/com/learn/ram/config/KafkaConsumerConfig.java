package com.learn.ram.config;

// Java Program to Illustrate Configuration Class


// Importing required classes
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.learn.ram.model.DeviceDto;

// Annotation
@EnableKafka
@Configuration

// Class
public class KafkaConsumerConfig {
    
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

	@Bean
	public ConsumerFactory<Integer, DeviceDto> consumerFactory()
	{

		// Creating a map of string-object type
		Map<String, Object> config = new HashMap<>();

		// Adding the Configuration
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				bootstrapServers);
		config.put(ConsumerConfig.GROUP_ID_CONFIG,
				"device");
		config.put(
			ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
			StringDeserializer.class);
		config.put(
			ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
			JsonDeserializer.class);

		// Returning message in JSON format
		return new DefaultKafkaConsumerFactory<>(
			config, new JsonDeserializer<>(Integer.class),
			new JsonDeserializer<>(DeviceDto.class));
	}

	// Creating a Listener
	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer,
												DeviceDto>
	deviceListener()
	{
		ConcurrentKafkaListenerContainerFactory<
		Integer, DeviceDto> factory
			= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
													
		return factory;
	}
}
