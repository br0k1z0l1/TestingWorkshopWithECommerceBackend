package com.example.ecommerce.backend.service;

import com.example.ecommerce.backend.dao.OrderDao;
import com.example.ecommerce.backend.dao.ProductDao;
import com.example.ecommerce.backend.dao.UserDao;
import com.example.ecommerce.backend.model.Product;
import com.example.ecommerce.backend.model.User;
import com.example.ecommerce.backend.model.Order;
import com.example.ecommerce.backend.requests.OrderRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrderDao orderDao;
    @Mock
    private UserDao userDao;
    @Mock
    private ProductDao productDao;

    @InjectMocks
    private OrderService orderService;

    private User user;
    private Order order;
    private OrderRequest orderRequest;
    private Product product;

    @BeforeEach
    public void init(){
        product = new Product();
        product.setId(1L);
        product.setName("shampoo");
        product.setDescription("testShampoo");
        product.setPrice(BigDecimal.valueOf(8.2));
        product.setInStock(2);

        user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("John@example.com");
        user.setPassword("Pass");

        order = new Order();
        order.setId(1L);
        order.setUser(user);
        order.setTotal(BigDecimal.valueOf(8.2));
        order.setQuantity(1);
        order.setOrderDate(LocalDate.of(2023,4,17));
        order.setProduct(product);

        orderRequest = new OrderRequest();
        orderRequest.setId(order.getId());
        orderRequest.setProductId(order.getProduct().getId());
        orderRequest.setQuantity(order.getQuantity());
        orderRequest.setOrderDate(order.getOrderDate());
        orderRequest.setTotal(order.getTotal());
        orderRequest.setUserId(order.getUser().getId());
    }

    @Test
    public void saveNewOrderShouldDecreaseProductInStock(){
        when(userDao.findById(user.getId())).thenReturn(Optional.of(user));
        when(productDao.findById(product.getId())).thenReturn(Optional.of(product));
        when(orderDao.save(any())).thenAnswer(i->i.getArguments()[0]);
        var actual = orderService.save(orderRequest).getProduct().getInStock();
        assertEquals(1, actual);
    }

    @Test
    public void findAllShouldReturnWithOrderDaoResponse() {
        when(orderDao.findAll()).thenReturn(List.of(order));
        assertEquals(List.of(order), orderService.findAll());
        verify(orderDao, times(1)).findAll();
    }


}
