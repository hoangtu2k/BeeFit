package com.spring.beefit.service;

import com.spring.beefit.entity.Material;
import com.spring.beefit.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository repository;

    public MaterialService(MaterialRepository repository) {
        this.repository = repository;
    }

    public List<Material> getAllMaterials() {
        return repository.getAll();
    }

}
