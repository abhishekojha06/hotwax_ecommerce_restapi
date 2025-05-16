package com.hotwaxcommerce.demo.repository;

import com.hotwaxcommerce.demo.model.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Integer> {
}
