package com.example.ecommerce.backend.dao;

import com.example.ecommerce.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
