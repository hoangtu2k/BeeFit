package com.spring.beefit.service;

import com.spring.beefit.repository.ProductDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    public ProductDetailService(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }



}
