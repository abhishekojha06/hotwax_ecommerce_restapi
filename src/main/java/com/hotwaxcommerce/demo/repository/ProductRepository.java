package com.hotwaxcommerce.demo.repository;

import com.hotwaxcommerce.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
