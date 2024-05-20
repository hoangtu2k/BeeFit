package com.spring.beefit.service;

import com.spring.beefit.entity.Brand;
import com.spring.beefit.repository.BrandRepository;
import com.spring.beefit.viewmodel.request.BrandReq;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {

    private final BrandRepository repository;

    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public List<Brand> getAllBrands() {
        return repository.getAll();
    }

    public Brand add(BrandReq request){
        Brand brand = new Brand();
        brand.setName(request.getName());
        brand.setCreateDate(new Date());
        brand.setStatus(0);
        return repository.save(brand);
    }

    public Brand update(Integer id,BrandReq request){
        Brand brand = repository.getById(id);
        brand.setName(request.getName());
        brand.setUpdateDate(new Date());
        return repository.save(brand);
    }

}
