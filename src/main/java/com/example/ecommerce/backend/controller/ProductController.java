package com.example.ecommerce.backend.controller;

import com.example.ecommerce.backend.model.Product;
import com.example.ecommerce.backend.service.ProductService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/api/product/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.of(productService.findById(id));
    }

    @PostMapping("/api/product")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        product = productService.save(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/api/product/{id}")
    public ResponseEntity<Product> update(
            @PathParam("id") Long id,
            @RequestBody Product product
    ) {
        if (!id.equals(product.getId()))
            return ResponseEntity.badRequest().build();
        product = productService.save(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/api/product/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
