package com.spring.beefit.service;

import com.spring.beefit.entity.Brand;
import com.spring.beefit.entity.Product;
import com.spring.beefit.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.getAll();
    }


}
