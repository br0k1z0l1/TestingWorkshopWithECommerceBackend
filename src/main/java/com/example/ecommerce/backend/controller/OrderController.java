package com.example.ecommerce.backend.controller;

import com.example.ecommerce.backend.model.Order;
import com.example.ecommerce.backend.requests.OrderRequest;
import com.example.ecommerce.backend.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/api/orders")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @PostMapping("/api/order")
    public ResponseEntity<Order> save(@RequestBody @Valid OrderRequest orderRequest, BindingResult errors) {
        if (errors.hasErrors()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(orderService.save(orderRequest));
    }

    @PutMapping("/api/order/{id}")
    public ResponseEntity<Order> save(@PathVariable("id") Long id, @RequestBody @Valid OrderRequest orderRequest, BindingResult errors) {
        if (!Objects.equals(orderRequest.getId(), id) || errors.hasErrors()) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(orderService.save(orderRequest));
    }

    @GetMapping("/api/order/{id}")
    public Optional<Order> findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @DeleteMapping("/api/order/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}
