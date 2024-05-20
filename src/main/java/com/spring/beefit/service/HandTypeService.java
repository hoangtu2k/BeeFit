package com.spring.beefit.service;

import com.spring.beefit.entity.HandType;
import com.spring.beefit.repository.HandTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandTypeService {

    private final HandTypeRepository repository;

    public HandTypeService(HandTypeRepository repository) {
        this.repository = repository;
    }

    public List<HandType> getAllHandTypes() {
        return repository.getAll();
    }

}
