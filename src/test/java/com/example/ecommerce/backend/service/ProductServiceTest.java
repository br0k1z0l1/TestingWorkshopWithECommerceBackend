package com.example.ecommerce.backend.service;

import com.example.ecommerce.backend.dao.ProductDao;
import com.example.ecommerce.backend.model.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductDao productDao;

    @InjectMocks
    private ProductService productService;

    private List<Product> products;

    @BeforeEach
    public void init() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("shampoo");
        product1.setDescription("testShampoo");
        product1.setPrice(BigDecimal.valueOf(8.2));
        product1.setInStock(2);
        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("conditioner");
        product2.setDescription("testConditioner");
        product2.setPrice(BigDecimal.valueOf(10.2));
        product2.setInStock(1);

        products = List.of(product1, product2);
    }


    @Test
    public void findAllShouldReturnWithProductDaoResponse() {
        when(productDao.findAll()).thenReturn(products);
        assertEquals(products, productService.findAll());
        verify(productDao, times(1)).findAll();
    }

}