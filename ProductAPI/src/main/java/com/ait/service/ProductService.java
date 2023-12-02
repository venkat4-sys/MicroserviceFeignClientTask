package com.ait.service;

import java.util.List;

import com.ait.dto.ProductDto;

public interface ProductService {
	
	public ProductDto saveProduct(ProductDto productdto);
	
	public List<ProductDto> getAllProducts();
		
	public ProductDto getProduct(Integer id);

}
