package br.com.bruno.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import br.com.bruno.producer.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class StringService {
	
	private  final RabbitTemplate rabbitTemplate;
	
	public void produce (String message) {
		
		log.info("Received message: "+message);
		
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME_MARKETPLACE,RabbitMQConfig.RK_PRODUCT_LOG,message);
		
	}

}
