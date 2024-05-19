package com.spring.beefit.service;

import com.spring.beefit.entity.Brand;
import com.spring.beefit.repository.BrandRepository;
import com.spring.beefit.viewmodel.request.BrandReq;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Brand add(BrandReq request){
        Brand brand = new Brand();
        brand.setName(request.getName());
        brand.setCreateDate(new Date());
        brand.setStatus(0);
        return brandRepository.save(brand);
    }

    public Brand update(Integer id,BrandReq request){
        Brand brand = brandRepository.getById(id);
        brand.setName(request.getName());
        brand.setUpdateDate(new Date());
        return brandRepository.save(brand);
    }


}
