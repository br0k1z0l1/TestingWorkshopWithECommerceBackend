package com.example.ecommerce.backend.dao;

import com.example.ecommerce.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {
}
