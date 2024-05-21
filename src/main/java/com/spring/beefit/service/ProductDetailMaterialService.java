package com.spring.beefit.service;

import com.spring.beefit.entity.Material;
import com.spring.beefit.repository.MaterialRepository;
import com.spring.beefit.repository.ProductDetailMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailMaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private ProductDetailMaterialRepository productDetailMaterialRepository;

    public List<Material> getAllMaterials() {
        return materialRepository.getAll();
    }

}
