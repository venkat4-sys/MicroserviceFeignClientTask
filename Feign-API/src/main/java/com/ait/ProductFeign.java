package com.ait;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="PRODUCT-API")
public interface ProductFeign {
	
	@GetMapping("/api/product/get/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id);
	
	@GetMapping("/api/product/getAll")
	public ResponseEntity<?> getAllProducts();

}
