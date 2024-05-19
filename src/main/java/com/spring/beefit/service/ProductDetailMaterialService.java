package com.spring.beefit.service;

import com.spring.beefit.repository.ProductDetailMaterialRepository;
import com.spring.beefit.repository.ProductDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailMaterialService {

    private final ProductDetailMaterialRepository productDetailMaterialRepository;

    public ProductDetailMaterialService(ProductDetailMaterialRepository productDetailMaterialRepository) {
        this.productDetailMaterialRepository = productDetailMaterialRepository;
    }



}
