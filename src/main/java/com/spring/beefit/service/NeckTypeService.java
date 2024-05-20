package com.spring.beefit.service;

import com.spring.beefit.entity.NeckType;
import com.spring.beefit.repository.NeckTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeckTypeService {

    private final NeckTypeRepository repository;

    public NeckTypeService(NeckTypeRepository repository) {
        this.repository = repository;
    }

    public List<NeckType> getAllNeckTypes() {
        return repository.getAll();
    }

}
