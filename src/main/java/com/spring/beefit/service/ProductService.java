package com.spring.beefit.service;

import com.spring.beefit.entity.Product;
import com.spring.beefit.repository.ProductRepository;
import com.spring.beefit.viewmodel.request.ProductReq;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String genCode() {
        // Tạo đối tượng Random
        long timestamp = Instant.now().getEpochSecond();
        String code = "SP" + timestamp;
        return code;
    }
    public Product add(ProductReq request){
        Product product = new Product();
        product.setCode(genCode());
        product.setName(request.getName());
        product.setCreateDate(new Date());
        product.setStatus(0);
        return productRepository.save(product);
    }
    public Product update(Integer id, ProductReq request){
        Product product = productRepository.getById(id);
        product.setName(request.getName());
        product.setUpdateDate(new Date());
        return productRepository.save(product);
    }

}
