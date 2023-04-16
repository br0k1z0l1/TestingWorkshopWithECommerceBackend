package com.example.ecommerce.backend.requests;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class OrderRequest {
    private Long id;

    @NotNull
    private Long productId;
    private int quantity;
    @FutureOrPresent
    private LocalDate orderDate;
    @NotNull
    private BigDecimal total;
    @NotNull
    private Long userId;
}