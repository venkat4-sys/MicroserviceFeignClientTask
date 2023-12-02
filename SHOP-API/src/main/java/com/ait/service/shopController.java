package com.ait.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.ProductFeign;

@RestController
@RequestMapping("/api/shop")
public class shopController {
	
	@Autowired
	private ProductFeign productfien;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id) {
		
		ResponseEntity<?> product = productfien.getProduct(id);
		
		return new ResponseEntity<>(product,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProducts() {
		ResponseEntity<?> allProducts = productfien.getAllProducts();
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	

	

}
