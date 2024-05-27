package com.spring.beefit.viewmodel.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartDetailRequest {
    private BigDecimal UnitPrice;
    private Integer IdColor ;
    private Integer IdSize;
    private Integer IdProduct;
    private Integer IdCart;
    private Integer Quantity;
}
