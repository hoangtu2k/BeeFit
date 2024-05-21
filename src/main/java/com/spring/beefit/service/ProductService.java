package com.spring.beefit.service;

import com.spring.beefit.entity.*;
import com.spring.beefit.repository.ProductRepository;
import com.spring.beefit.viewmodel.request.ProductReq;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public List<Product> getAll1() {
        return productRepository.getAll1();
    }

    public Product getById(Integer id){
        Product product = productRepository.getById(id);
        return product;
    }

    public String genCode() {
        // Tạo đối tượng Random
        long timestamp = Instant.now().getEpochSecond();
        String code = "SP" + timestamp;
        return code;
    }

    public Product add(ProductReq request) {
        Product product = new Product();
        product.setCode(genCode());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDiscount(request.getDiscount());
        product.setDescription(request.getDescription());
        product.setBrand(Brand.builder().id(request.getIdBrand()).build());
        product.setCategory(Category.builder().id(request.getIdCategory()).build());
        product.setDesign(Design.builder().id(request.getIdDesign()).build());
        product.setHandType(HandType.builder().id(request.getIdHandType()).build());
        product.setNeckType(NeckType.builder().id(request.getIdNeckType()).build());
        product.setDiscountDate(request.getDiscountDate());
        product.setCreateDate(new Date());
        product.setStatus(0);
        return productRepository.save(product);
    }


    public Product delete(Integer IdProduct){
        Product p = productRepository.getById(IdProduct);
        p.setStatus(1);
        return productRepository.save(p);
    }
    public Product khoiphucDelete(Integer IdProductDetail){
        Product p = productRepository.getById(IdProductDetail);
        p.setStatus(0);
        return productRepository.save(p);
    }

}
