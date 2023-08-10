package br.com.bruno.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.producer.dto.ProductDTO;
import br.com.bruno.producer.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	
	
	@Autowired
	private ProductService service;

	
	@GetMapping
	public ResponseEntity<String> produces (@RequestBody ProductDTO dto){
		service.createProduct(dto);
		
		return ResponseEntity.ok("Sending message");
	}

}
