package com.spring.beefit.service;

import com.spring.beefit.entity.ProductDetail;
import com.spring.beefit.repository.ProductDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailService {

    private final ProductDetailRepository productDetailRepository;

    public ProductDetailService(ProductDetailRepository productDetailRepository) {
        this.productDetailRepository = productDetailRepository;
    }

    public List<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }

    public List<ProductDetail> getAll() {
        return productDetailRepository.getAll();
    }

    public List<ProductDetail> getAll1() {
        return productDetailRepository.getAll1();
    }




}
