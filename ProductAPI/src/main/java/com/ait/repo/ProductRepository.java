package com.ait.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
