package br.com.bruno.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.producer.config.RabbitMQConfig;
import br.com.bruno.producer.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {
	
	@Autowired
	private final RabbitTemplate rabbitTemplate;
	
	public void createProduct(ProductDTO dto) {
		log.info("Sending a message to exchange:"+dto.toString());
		
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME_MARKETPLACE,RabbitMQConfig.RK_PRODUCT_LOG, dto);
	}

}
