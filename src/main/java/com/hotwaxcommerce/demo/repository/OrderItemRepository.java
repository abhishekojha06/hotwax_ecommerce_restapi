package com.hotwaxcommerce.demo.repository;

import com.hotwaxcommerce.demo.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
