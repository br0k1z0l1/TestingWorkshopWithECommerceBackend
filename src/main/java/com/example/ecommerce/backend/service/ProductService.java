package com.example.ecommerce.backend.service;

import com.example.ecommerce.backend.dao.ProductDao;
import com.example.ecommerce.backend.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    }

    public Product save(Product p) {
        return productDao.save(p);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}
