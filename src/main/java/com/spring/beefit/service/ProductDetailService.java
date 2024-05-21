package com.spring.beefit.service;

import com.spring.beefit.entity.*;
import com.spring.beefit.repository.ProductDetailRepository;
import com.spring.beefit.viewmodel.request.ProductDetailReq;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public ProductDetail getById(Integer id){
        ProductDetail productDetail = productDetailRepository.getById(id);
        return productDetail;
    }

    public ProductDetail add(ProductDetailReq request) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setPrice(request.getPrice());
        productDetail.setDiscount(request.getDiscount());
        productDetail.setDescription(request.getDescription());
        productDetail.setProduct(Product.builder().id(request.getIdProduct()).build());
        productDetail.setBrand(Brand.builder().id(request.getIdBrand()).build());
        productDetail.setCategory(Category.builder().id(request.getIdCategory()).build());
        productDetail.setDesign(Design.builder().id(request.getIdDesign()).build());
        productDetail.setHandType(HandType.builder().id(request.getIdHandType()).build());
        productDetail.setNeckType(NeckType.builder().id(request.getIdNeckType()).build());
        productDetail.setDiscountDate(request.getDiscountDate());
        productDetail.setCreateDate(new Date());
        productDetail.setStatus(0);
        return productDetailRepository.save(productDetail);
    }




}
