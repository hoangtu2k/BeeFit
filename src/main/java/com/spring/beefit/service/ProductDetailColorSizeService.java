package com.spring.beefit.service;

import com.spring.beefit.repository.ProductDetailColorSizeRepository;
import com.spring.beefit.repository.ProductDetailMaterialRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailColorSizeService {

    private final ProductDetailColorSizeRepository productDetailColorSizeRepository;

    public ProductDetailColorSizeService(ProductDetailColorSizeRepository productDetailColorSizeRepository) {
        this.productDetailColorSizeRepository = productDetailColorSizeRepository;
    }



}
