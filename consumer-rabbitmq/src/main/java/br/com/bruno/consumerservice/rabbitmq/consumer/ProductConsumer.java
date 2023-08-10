package br.com.bruno.consumerservice.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.bruno.consumerservice.dto.ProductDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ProductConsumer {
	
	@RabbitListener(queues = {"product.log"})
	public void consumer( ProductDTO dto) {
		
		log.info("Consumer received a message: "+dto.toString());
		
	}

}
