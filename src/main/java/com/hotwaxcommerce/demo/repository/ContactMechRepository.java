package com.hotwaxcommerce.demo.repository;

import com.hotwaxcommerce.demo.model.ContactMech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMechRepository extends JpaRepository<ContactMech, Integer> {
}
