package com.example.ecommerce.backend.service;

import com.example.ecommerce.backend.dao.OrderDao;
import com.example.ecommerce.backend.dao.ProductDao;
import com.example.ecommerce.backend.dao.UserDao;
import com.example.ecommerce.backend.model.Order;
import com.example.ecommerce.backend.model.Product;
import com.example.ecommerce.backend.requests.OrderRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
    private final UserDao userDao;
    private final ProductDao productDao;


    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Transactional
    public Order save(@Valid OrderRequest orderRequest) {
        Order order = toOrder(orderRequest);
        Product product = order.getProduct();

        int previouslyOrdered = order.getId() == null ? 0 : orderDao.findById(order.getId()).map(Order::getQuantity).orElse(0);
        product.decreaseInStock(orderRequest.getQuantity() - previouslyOrdered);

        order = orderDao.save(order);
        productDao.save(product);
        return order;
    }

    public Optional<Order> findById(Long id) {
        return orderDao.findById(id);
    }

    public void deleteById(Long id) {
        orderDao.deleteById(id);
    }

    private Order toOrder(OrderRequest orderRequest) {
        Order o = new Order();
        o.setId(orderRequest.getId());
        o.setOrderDate(orderRequest.getOrderDate());
        o.setUser(userDao.findById(orderRequest.getUserId()).orElseThrow());
        o.setProduct(productDao.findById(orderRequest.getProductId()).orElseThrow());
        o.setTotal(orderRequest.getTotal());
        o.setQuantity(orderRequest.getQuantity());
        return o;
    }
}
