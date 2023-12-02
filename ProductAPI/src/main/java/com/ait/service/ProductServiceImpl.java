package com.ait.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.dto.ProductDto;
import com.ait.entity.Product;
import com.ait.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private  ProductRepository productRepo;
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> listofproducts = productRepo.findAll();
		List<ProductDto> prod=new ArrayList<>();
		for(Product products:listofproducts) {
			ProductDto productdto=new ProductDto();
			BeanUtils.copyProperties(products, productdto);
			prod.add(productdto);
		}
		return prod;
	}
	@Override
	public ProductDto saveProduct(ProductDto productdto) {
		Product products=new Product();
		BeanUtils.copyProperties(productdto, products);
		 Product save = productRepo.save(products);
		 ProductDto dto=new ProductDto();
		 BeanUtils.copyProperties(save, dto);
		
		return dto;
	}
	
	@Override
	public ProductDto getProduct(Integer id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			Product entity = product.get();
			ProductDto proddto=new ProductDto();
			BeanUtils.copyProperties(entity, proddto);
			return proddto;
		}
		return null;
	}

}
