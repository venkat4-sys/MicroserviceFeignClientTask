package com.ait.rest;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.ProductDto;
import com.ait.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductRestController {

	@Autowired
	private ProductService ProductService;

	@PostMapping("/save")
	public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto proddto) {
		log.info("request to the {} save product intiated..");
		ProductDto product = ProductService.saveProduct(proddto);
		return new ResponseEntity<ProductDto>(product, org.springframework.http.HttpStatus.OK);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id) {
		log.info("request to the {} get product intiated..");
		ProductDto product = ProductService.getProduct(id);
		return new ResponseEntity<ProductDto>(product, org.springframework.http.HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProducts() {
		log.info("request to the {} get all products intiated..");
		List<ProductDto> allProducts = ProductService.getAllProducts();
		return new ResponseEntity<>(allProducts, org.springframework.http.HttpStatus.OK);

	}

}
