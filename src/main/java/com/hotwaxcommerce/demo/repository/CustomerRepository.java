package com.hotwaxcommerce.demo.repository;

import com.hotwaxcommerce.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
